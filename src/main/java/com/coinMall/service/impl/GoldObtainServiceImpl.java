package com.coinMall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.coinMall.bean.PageModel;
import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.enums.Subcode;
import com.coinMall.bean.in.gold.PlatformInfoRequest;
import com.coinMall.bean.out.gold.GoldLogModel;
import com.coinMall.bean.out.user.UserExpansionInfo;
import com.coinMall.common.BaseService;
import com.coinMall.dao.GoldLogMapper;
import com.coinMall.dao.GoldRuleMapper;
import com.coinMall.dao.PlatformInfoMapper;
import com.coinMall.dao.PlatformRechargeLogMapper;
import com.coinMall.pojo.GoldLog;
import com.coinMall.pojo.GoldRule;
import com.coinMall.pojo.PlatformInfo;
import com.coinMall.pojo.PlatformRechargeLog;
import com.coinMall.pojo.UserInfo;
import com.coinMall.service.GoldObtainService;
import com.coinMall.util.DateUtil;
import com.coinMall.util.RandomUtil;
@Service
public class GoldObtainServiceImpl extends BaseService implements GoldObtainService{

	@Override
	public ReturnModel obtainGold(Integer uid, Integer rule_id, String md5_key, String timestamp) {
		ReturnModel model = new ReturnModel();
		try {
			//验证时间撮
			if(timestamp.length() != 13) return setModelError(model,Subcode.PARAM_ERROR);
			
			//验证KEY
			if(!verifyKey(md5_key,timestamp,uid,rule_id)) return setModelError(model,Subcode.PARAM_ERROR);
			
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(model,Subcode.PARAM_ERROR);
			//获取规则信息
			GoldRule goldRule = goldRuleMapper.selectByPrimaryKey(rule_id);
			//检查赠送规则传入的ID
			if(null == goldRule) return setModelError(model,Subcode.PARAM_ERROR);
			//获取平台信息
			PlatformInfo platformInfo = platformInfoMapper.selectByPrimaryKey(goldRule.getPlatformId());
			
			//找到用户
			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
			//检查用户是否存在金币商城数据库中，不存在就初始该用户数据
			userInfo = checkUser(userInfo, uid);
			
			//检查金币赠送规则是否满足要求，并获取金币赠送值
			double gold = checkObtainGold(goldRule, uid);
			if(gold==-1) return setModelError(model,Subcode.OBTAIN_REPEAT_ERROR);
			//判断平台拥有的金币数是否满足赠送的金币额度，在这里需要加入钉钉提醒功能
			if(gold >= platformInfo.getPlatformGold()) return setModelError(model,Subcode.GOLD_NOT_ENOUGH);
			//记录赠送日志
			GoldLog log = new GoldLog();
			log.setObtainGold(gold);
			log.setPlatformId(platformInfo.getPlatformId());
			log.setObtainTime(new Date());
			log.setObtainDescription(goldRule.getRuleDescription());
			log.setRuleId(goldRule.getRuleId());
			log.setUid(uid);
			goldLogMapper.insert(log);
			//增加用户金币总数
			userInfo.setGoldTotal(userInfo.getGoldTotal()+gold);
			userInfoMapper.updateByPrimaryKeySelective(userInfo);
			//减少平台金币总数
			platformInfo.setPlatformGold(platformInfo.getPlatformGold()-gold);
			platformInfoMapper.updateByPrimaryKeySelective(platformInfo);
			
		} catch (Exception e) {
			logger.error("赠送金币异常", e);
			model.setCode(-1);
			model.setMessage("赠送金币异常");
		}
		return model;
	}
	
	//查询用户金币
	@Override
	public ReturnModel getGoldByUserId(Integer uid) {
		ReturnModel model = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(model,Subcode.PARAM_ERROR);
			//找到用户
			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
			//检查用户是否存在金币商城数据库中，不存在就初始该用户数据
			userInfo = checkUser(userInfo, uid);
			//组装返回对象
			UserExpansionInfo info = new UserExpansionInfo();
			info.setGoldTotal(userInfo.getGoldTotal());
			info.setUid(userInfo.getUid());
			model.setBodyMessage(JSON.toJSONString(info));
		} catch (Exception e) {
			logger.error("查询金币总数异常", e);
			model.setCode(-1);
			model.setMessage("查询金币总数异常");
		}
		return model;
	}
	//分页查询金币日志
	@Override
	public ReturnModel getGoldLogOfPage(Integer uid, Integer pageIndex, Integer pageSize) {
		ReturnModel model = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(model,Subcode.PARAM_ERROR);
			//找到用户
			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
			//检查用户是否存在金币商城数据库中，不存在就初始该用户数据
			userInfo = checkUser(userInfo, uid);
			//实例分页
			PageModel<GoldLogModel> pageModel = new PageModel<GoldLogModel>(pageIndex, pageSize);
			//分页查询金币赠送集合
			List<GoldLog> list = goldLogMapper.getGoldLogOfPage(uid, (pageIndex-1) * pageSize, pageSize);
			//组装返回集合
			ArrayList<GoldLogModel> datas = new ArrayList<GoldLogModel>();
			//查询总数
			int totalCount = goldLogMapper.getGoldLogCountByUserId(uid);
			//组装返回对象
			if(null!=list && list.size()>0)
				for (GoldLog goldLog : list) {
					GoldLogModel m = new GoldLogModel();
					m.setObtainDescription(goldLog.getObtainDescription());
					m.setObtainGold(goldLog.getObtainGold());
					m.setObtainTime(goldLog.getObtainTime().getTime());
					m.setObtainId(goldLog.getObtainId());
					datas.add(m);
				}
			pageModel.setPageDatas(datas);
			pageModel.setTotalCount(totalCount);
			model.setBodyMessage(JSON.toJSONString(pageModel));
		} catch (Exception e) {
			logger.error("查询金币总数异常", e);
			model.setCode(-1);
			model.setMessage("查询金币总数异常");
		}
		return model;
	}
	
	//查询平台信息
	@Override
	public ReturnModel getPlatformInfoList() {
		ReturnModel model = new ReturnModel();
		try {
			List<PlatformInfo> info = platformInfoMapper.selectAll();
			model.setBodyMessage(JSON.toJSONString(info));
		} catch (Exception e) {
			logger.error("查询平台信息异常", e);
			model.setCode(-1);
			model.setMessage("查询平台信息异常");
		}
		return model;
	}
	//添加或修改平台
	@Override
	public ReturnModel addPlatformInfo(PlatformInfoRequest rq) {
		ReturnModel model = new ReturnModel();
		try {
			if(rq.getPlatformType()<1||rq.getPlatformType()>2) return setModelError(model, Subcode.PARAM_ERROR);
			if(rq.getPlatformGold()<0) return setModelError(model, Subcode.PARAM_ERROR);
			if(rq.getPlatformName().trim().equals("")) return setModelError(model, Subcode.PARAM_ERROR);
			PlatformInfo info = null;
			if(null == rq.getPlatformId()) {
				info = new PlatformInfo();
				info.setPlatformGold(rq.getPlatformGold());
				info.setPlatformName(rq.getPlatformName());
				info.setPlatformType(rq.getPlatformType());
				platformInfoMapper.insert(info);
			}else {
				info = platformInfoMapper.selectByPrimaryKey(rq.getPlatformId());
				if(info==null) return setModelError(model, Subcode.PARAM_ERROR);
				info.setPlatformGold(rq.getPlatformGold());
				info.setPlatformName(rq.getPlatformName());
				info.setPlatformType(rq.getPlatformType());
				platformInfoMapper.updateByPrimaryKeySelective(info);
			}
		} catch (Exception e) {
			logger.error("添加或修改平台信息异常", e);
			model.setCode(-1);
			model.setMessage("添加或修改平台信息异常");
		}
		return model;
	}
	//平台充值
	@Override
	public ReturnModel platformRecharge(Integer platformId, double amount,String ip) {
		ReturnModel model = new ReturnModel();
		try {
			if(amount<=0) return setModelError(model, Subcode.PARAM_ERROR);
			PlatformInfo info = platformInfoMapper.selectByPrimaryKey(platformId);
			if(info==null) return setModelError(model, Subcode.PARAM_ERROR);
			info.setPlatformGold(info.getPlatformGold()+amount);
			platformInfoMapper.updateByPrimaryKeySelective(info);
			PlatformRechargeLog log = new PlatformRechargeLog();
			log.setPlatformId(platformId);
			log.setRechargeAmount(amount);
			log.setRechargeGold(amount);
			log.setRechargeTime(new Date());
			log.setRechargeIp(ip);
			platformRechargeLogMapper.insert(log);
		} catch (Exception e) {
			logger.error("平台充值异常", e);
			model.setCode(-1);
			model.setMessage("平台充值异常");
		}
		return model;
	}
	
	
	/*********************************************************私有方法******************************************************/
	
	private boolean verifyKey(String md5_key,String timestamp,Integer uid,Integer rule_id) {
		StringBuilder sb = new StringBuilder();
		sb.append(KEY_START);
		sb.append(timestamp);
		sb.append("-"+uid+"-");
		sb.append(rule_id);
		sb.append(KEY_END);
		String key = DigestUtils.md5Hex(sb.toString()).toUpperCase();
		if(key.equals(md5_key))
			return true;
		logger.info("验证KEY失败:"+md5_key);
		return false;
	}
	
	private double checkObtainGold(GoldRule goldRule,Integer uid) {
		double gold = -1;
		int count = 0;
		switch (goldRule.getRuleType()) {
		case 0://无上限
			gold = randomGold(goldRule);
			break;
			
		case 1://每天赠送1次
			count = goldLogMapper.getLogCountByUserRuleIdTime(uid, goldRule.getRuleId(), DateUtil.dateToStrShort());
			if(count==0) gold = randomGold(goldRule);
			break;
			
		case 2://只赠送1次
			count = goldLogMapper.getLogCountByUserRuleIdTime(uid, goldRule.getRuleId(), null);
			if(count==0) gold = randomGold(goldRule);
			break;
			
		case 4://最多赠送4次
			count = goldLogMapper.getLogCountByUserRuleIdTime(uid, goldRule.getRuleId(), null);
			if(count<4) gold = randomGold(goldRule);
			break;
		}
		return gold;
	}
	
	private double randomGold(GoldRule goldRule) {
		//获取赠送规则下的平均值
		double avg = goldLogMapper.getLogAvgByRuleId(goldRule.getRuleId());
		//如果统计出的平均值小于或等于设定值，应随机获取大于设定值的赠送金币范围
		if(avg > 0 && avg <= goldRule.getRuleAverageValue()) return RandomUtil.getDoubleRandomBetween(goldRule.getRuleAverageValue(), goldRule.getRuleMaxValue());
		//如果统计出的平均值大于设定值，应随机获取小于设定值的赠送金币范围
		else return RandomUtil.getDoubleRandomBetween(goldRule.getRuleMinValue(), goldRule.getRuleAverageValue());
	}
	
	private static Logger logger = Logger.getLogger(GoldObtainServiceImpl.class);
	@Autowired
	private GoldRuleMapper goldRuleMapper;
	@Autowired
	private PlatformInfoMapper platformInfoMapper;
	@Autowired
	private GoldLogMapper goldLogMapper;
	@Autowired
	private PlatformRechargeLogMapper platformRechargeLogMapper;
	
}
