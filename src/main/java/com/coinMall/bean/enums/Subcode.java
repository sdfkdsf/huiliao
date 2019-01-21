package com.coinMall.bean.enums;
/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
public enum Subcode {
	
	PARAM_ERROR(700001,"参数错误"),
	BUSINESS_ERROR(700002,"业务异常"),
	OBTAIN_REPEAT_ERROR(700003,"重复赠送金币"),
	GOLD_NOT_ENOUGH(700004,"平台金币不足"),
	RECEIPT_DEFAULT_NOT_FOUND(700005,"未查询到默认地址"),
	OPERATION_ERROR(700006,"操作异常");
	
	private long subcode;
	private String message;
	
	Subcode(long subcode,String message){
		this.subcode = subcode;
		this.message = message;
	}

	public long getSubcode() {
		return subcode;
	}

	public void setSubcode(long subcode) {
		this.subcode = subcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
