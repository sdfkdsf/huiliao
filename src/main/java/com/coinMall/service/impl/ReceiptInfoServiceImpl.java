package com.coinMall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.enums.Subcode;
import com.coinMall.bean.enums.UserConst;
import com.coinMall.bean.in.user.ReceiptInfoModel;
import com.coinMall.bean.out.user.ReceiptInfoReturn;
import com.coinMall.common.BaseService;
import com.coinMall.dao.ReceiptInfoMapper;
import com.coinMall.pojo.ReceiptInfo;
import com.coinMall.service.ReceiptInfoService;

/** 
 * @author jiangjiayi
 * @date 2018年10月19日
 */
@Service
public class ReceiptInfoServiceImpl extends BaseService implements ReceiptInfoService {

	private static Logger logger = Logger.getLogger(ReceiptInfoServiceImpl.class);
	
	@Autowired
	private ReceiptInfoMapper receiptInfoMapper;
	
	@Override
	public ReturnModel addReceiptInfo(ReceiptInfoModel receiptInfoModel) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//最多能保存20个有效收货地址
			int count = receiptInfoMapper.getReceiptInfoCountByUid(receiptInfoModel.getUid());
			if(count >= 20){
				returnModel.setSubCode(Subcode.BUSINESS_ERROR.getSubcode());
				returnModel.setMessage("最多能保存20个有效收货地址");
				return returnModel;
			}
			
			//取消原来默认收货地址
			if(receiptInfoModel.getReceiptDefault() == UserConst.RECEIPT_DEFAULT_YES.getCode()){
				ReceiptInfo receiptDefaultByUid = receiptInfoMapper.getReceiptDefaultByUid(receiptInfoModel.getUid());
				if(receiptDefaultByUid != null){
					ReceiptInfo record = new ReceiptInfo();
					record.setReceiptId(receiptDefaultByUid.getReceiptId());
					record.setReceiptDefault(UserConst.RECEIPT_DEFAULT_NO.getCode());//改为非默认
					receiptInfoMapper.updateByPrimaryKeySelective(record);
				}
			}
			
			ReceiptInfo receiptInfo = new ReceiptInfo();
			BeanUtils.copyProperties(receiptInfo, receiptInfoModel);
			receiptInfo.setReceiptId(null);
			receiptInfo.setReceiptCountry("中国");
			receiptInfoMapper.insertSelective(receiptInfo);
		} catch (Exception e) {
			logger.error("新增收货地址异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("新增收货地址异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel getReceiptInfoList(Integer uid) {
		ReturnModel returnModel = new ReturnModel();
		try {
			List<ReceiptInfo> receiptInfos = receiptInfoMapper.getReceiptInfoList(uid);
			List<ReceiptInfoReturn> receiptInfoReturns = new ArrayList<>();
			for (ReceiptInfo receiptInfo : receiptInfos) {
				ReceiptInfoReturn receiptInfoReturn = new ReceiptInfoReturn();
				BeanUtils.copyProperties(receiptInfoReturn, receiptInfo);
				receiptInfoReturn.setReceiptFullAddress(receiptInfo.getReceiptProvince()+receiptInfo.getReceiptCity()+receiptInfo.getReceiptDistrict()+receiptInfo.getReceiptDetailAddress());
				receiptInfoReturns.add(receiptInfoReturn);
			}
			returnModel.setBodyMessage(JSON.toJSONString(receiptInfoReturns));
		} catch (Exception e) {
			logger.error("查询收货地址列表异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("查询收货地址列表异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel getReceiptInfoById(Integer receiptId) {
		ReturnModel returnModel = new ReturnModel();
		try {
			ReceiptInfo receiptInfo = receiptInfoMapper.selectByPrimaryKey(receiptId);
			ReceiptInfoReturn receiptInfoReturn = new ReceiptInfoReturn();
			BeanUtils.copyProperties(receiptInfoReturn, receiptInfo);
			returnModel.setBodyMessage(JSON.toJSONString(receiptInfoReturn));
		} catch (Exception e) {
			logger.error("根据id查询收货地址详情异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("根据id查询收货地址详情异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel updateReceiptInfo(ReceiptInfoModel receiptInfoModel) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(receiptInfoModel.getUid())) return setModelError(returnModel, Subcode.PARAM_ERROR);
			//ID不能为空
			if(receiptInfoModel.getReceiptId() == null || receiptInfoModel.getReceiptId() == 0) return setModelError(returnModel, Subcode.PARAM_ERROR);
			
			//取消原来默认收货地址
			if(receiptInfoModel.getReceiptDefault() == UserConst.RECEIPT_DEFAULT_YES.getCode()){
				ReceiptInfo receiptDefaultByUid = receiptInfoMapper.getReceiptDefaultByUid(receiptInfoModel.getUid());
				if(receiptDefaultByUid != null){
					ReceiptInfo record = new ReceiptInfo();
					record.setReceiptId(receiptDefaultByUid.getReceiptId());
					record.setReceiptDefault(UserConst.RECEIPT_DEFAULT_NO.getCode());//改为非默认
					int updateByPrimaryKey = receiptInfoMapper.updateByPrimaryKeySelective(record);
					
					//取消失败，不设置为默认地址
					if(updateByPrimaryKey == 0){
						receiptInfoModel.setReceiptDefault(UserConst.RECEIPT_DEFAULT_NO.getCode());
					}
				}
			}
			
			ReceiptInfo receiptInfo = new ReceiptInfo();
			BeanUtils.copyProperties(receiptInfo, receiptInfoModel);
			receiptInfoMapper.updateByPrimaryKeySelective(receiptInfo);
		} catch (Exception e) {
			logger.error("修改收货地址异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("修改收货地址异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel deleteReceiptInfoById(Integer receiptId, Integer uid) {
		ReturnModel returnModel = new ReturnModel();
		try {
			int deleteByPrimaryKey = receiptInfoMapper.deleteByPrimaryKey(receiptId);
			
			//删除成功，将最近添加的收货地址设置为默认地址
			if(deleteByPrimaryKey > 0){
				List<ReceiptInfo> receiptInfoList = receiptInfoMapper.getReceiptInfoList(uid);
				if(receiptInfoList != null && receiptInfoList.size() > 0){
					ReceiptInfo receiptInfo = receiptInfoList.get(0);
					ReceiptInfo record = new ReceiptInfo();
					record.setReceiptId(receiptInfo.getReceiptId());
					record.setReceiptDefault(UserConst.RECEIPT_DEFAULT_YES.getCode());
					receiptInfoMapper.updateByPrimaryKeySelective(record);
				}
			}
		} catch (Exception e) {
			logger.error("根据id删除收货地址异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("根据id删除收货地址详情异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel getReceiptDefaultByUid(Integer uid) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(returnModel, Subcode.PARAM_ERROR);
			
			ReceiptInfo receiptDefaultByUid = receiptInfoMapper.getReceiptDefaultByUid(uid);
			if(receiptDefaultByUid != null){
				ReceiptInfoReturn rir = new ReceiptInfoReturn();
				BeanUtils.copyProperties(rir, receiptDefaultByUid);
				rir.setReceiptFullAddress(rir.getReceiptProvince()+rir.getReceiptCity()+rir.getReceiptDistrict()+rir.getReceiptDetailAddress());
				returnModel.setBodyMessage(rir);
			}else{
				return setModelError(returnModel, Subcode.RECEIPT_DEFAULT_NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("根据用户ID查询默认地址异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("根据用户ID查询默认地址异常");
		}
		return returnModel;
	}

}
