package com.coinMall.service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.gold.PlatformInfoRequest;

/**
 * 金币充值服务接口
 * @author Wayne.M
 * 2018年10月24日
 */
public interface GoldObtainService {
	static final String KEY_START = "6bb8d6b3-08d1-";
	static final String KEY_END = "-b948-4f1da85ddd8d";
	/**
	 * 赠送金币
	 * @param uid
	 * @param rule_id
	 * @param md5_key
	 * @param timestamp
	 * @return
	 */
	ReturnModel obtainGold(Integer uid, Integer rule_id, String md5_key, String timestamp);
	/**
	 * 根据用户ID查询用户的金币总数
	 * @param uid
	 * @return
	 */
	ReturnModel getGoldByUserId(Integer uid);
	/**
	 * 根据用户ID分页查询平台金币赠送日志
	 * @param uid
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ReturnModel getGoldLogOfPage(Integer uid, Integer pageIndex, Integer pageSize);
	
	/**
	 * 查询出所有的平台信息集合
	 * @return
	 */
	ReturnModel getPlatformInfoList();
	/**
	 * 添加或修改平台信息
	 * @param rq
	 * @return
	 */
	ReturnModel addPlatformInfo(PlatformInfoRequest rq);
	/**
	 * 平台充值
	 * @param platformId
	 * @param amount
	 * @return
	 */
	ReturnModel platformRecharge(Integer platformId, double amount,String ip);
}
