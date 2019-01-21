package com.coinMall.bean.enums;
/** 
 * 用户相关常量
 * @author jiangjiayi
 * @date 2018年10月19日
 */
public enum UserConst {
	RECEIPT_DEFAULT_NO(0,"非默认收货地址"),RECEIPT_DEFAULT_YES(1,"默认收货地址");
	
	private int code;
	private String text;
	
	UserConst(int code, String text){
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
