package com.coinMall.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.enums.Subcode;
import com.coinMall.bean.out.user.UserSmallModel;
import com.coinMall.common.api.BaseServerApi;
import com.coinMall.common.api.UserServerApi;
import com.coinMall.common.httpclient.HttpService;
import com.coinMall.dao.UserInfoMapper;
import com.coinMall.pojo.UserInfo;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@Service
public class BaseService {

	private static Logger logger = Logger.getLogger(BaseService.class);
	
	@Autowired
	protected BaseServerApi baseServerApi;
	
	@Autowired
	protected UserServerApi userServerApi;
	
	@Autowired
	protected HttpService httpService;
	
	@Autowired
	protected UserInfoMapper userInfoMapper;
	
	/**
	 * 获取ip所在地址
	 * @param ip
	 * @return
	 * @throws Exception 
	 */
	public String getLocationByIp(String ip) throws Exception{
		String result = null;
		Map<String, Object> map = new HashMap<>();
		map.put("ip", ip);
		try {
			result = httpService.doGet(baseServerApi.getLocation(), map);
			JSONObject jsonResult = JSON.parseObject(result);
			if(0 == jsonResult.getIntValue("code")){
				JSONObject jsonBodyMessage = JSON.parseObject(jsonResult.getString("bodyMessage"));
				return jsonBodyMessage.getString("Location");
			}
		} catch (Exception e) {
			logger.error("httpclient获取ip所在地址异常，result="+result, e);
			throw e;
		}
		return null;
	}
	
	/**
	 * 根据用户id集合获取用户信息集合
	 * @param ip
	 * @return
	 * @throws Exception 
	 */
	public List<UserSmallModel> querySmallUserList(Collection<Integer> uids) throws Exception{
		String result = null;
		String json = JSON.toJSONString(uids);
		try {
			logger.debug("requestParams:"+json);
			result = httpService.doPostJson(userServerApi.queryUserList(), json);			
			JSONObject jsonResult = JSON.parseObject(result);
			if(0 == jsonResult.getIntValue("code")){
				return JSON.parseArray(jsonResult.getString("bodyMessage"), UserSmallModel.class);
			}
		} catch (Exception e) {
			logger.error("httpclient根据用户id集合获取用户信息集合异常，result="+result, e);
			throw e;
		}
		return null;
	}
	
	/**
	 * 根据用户id获取用户信息
	 * @param ip
	 * @return
	 * @throws Exception 
	 */
	protected UserSmallModel querySmallUser(String uid) throws Exception{
		String result = null;
		Map<String, Object> map = new HashMap<>();
		map.put("id", uid);
		try {
			result = httpService.doGet(userServerApi.getByUserId(), map);			
			JSONObject jsonResult = JSON.parseObject(result);
			if(0 == jsonResult.getIntValue("code")){
				return JSON.parseObject(jsonResult.getString("bodyMessage"), UserSmallModel.class);
			}
		} catch (Exception e) {
			logger.error("httpclient根据用户id获取用户信息异常，result="+result, e);
			throw e;
		}
		return null;
	}
	
	protected boolean verifyUser(Integer uid) throws Exception {
		UserSmallModel userModel = querySmallUser(String.valueOf(uid));
		if(null != userModel)
			return true;
		logger.info("验证用户失败:"+uid);
		return false;
	}
	
	protected UserInfo checkUser(UserInfo userInfo,Integer uid) {
		if(null == userInfo) {
			userInfo = new UserInfo();
			userInfo.setUid(uid);
			userInfo.setGoldTotal(0.00);
			userInfoMapper.insert(userInfo);
		}
		return userInfo;
	}
	
	protected ReturnModel setModelError(ReturnModel model,Subcode subCode) {
		model.setSubCode(subCode.getSubcode());
		model.setMessage(subCode.getMessage());
		return model;
	}
	
	
}
