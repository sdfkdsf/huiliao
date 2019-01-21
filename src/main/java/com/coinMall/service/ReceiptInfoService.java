package com.coinMall.service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.user.ReceiptInfoModel;

/** 
 * @author jiangjiayi
 * @date 2018年10月19日
 */
public interface ReceiptInfoService {

	/**
	 * 新增收货地址
	 * @param receiptInfoModel
	 * @return
	 */
	ReturnModel addReceiptInfo(ReceiptInfoModel receiptInfoModel);
	
	/**
     * 收货地址列表
     * @param uid
     * @return
     */
	ReturnModel getReceiptInfoList(Integer uid);
	
	/**
	 * 根据id查询收货地址详情
	 * @param receiptId
	 * @return
	 */
	ReturnModel getReceiptInfoById(Integer receiptId);
	
	/**
	 * 修改收货地址
	 * @param receiptInfoModel
	 * @return
	 */
	ReturnModel updateReceiptInfo(ReceiptInfoModel receiptInfoModel);
	
	/**
	 * 根据id删除收货地址
	 * @param receiptId
	 * @param uid
	 * @return
	 */
	ReturnModel deleteReceiptInfoById(Integer receiptId, Integer uid);
	
	/**
	 * 根据用户ID查询默认地址
	 * @param receiptId
	 * @param uid
	 * @return
	 */
	ReturnModel getReceiptDefaultByUid(Integer uid);
}
