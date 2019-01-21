package com.coinMall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**   
* @author xiao.huiyu  
* @date 2018年10月13日  新建  
*/
@ApiModel(value = "统一返回模型")
public class ReturnModel {
	@ApiModelProperty(value = "返回的代码，通常为0为正常")
	private int code=0;
	
	@ApiModelProperty(value = "服务响应提示消息")
	private String message="ok";
	
	@ApiModelProperty(value = "服务响应的结果信息对象")
	private Object bodyMessage;
	
	@ApiModelProperty(value = "业务状态码")
	private long subCode = 0;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBodyMessage() {
		return bodyMessage;
	}

	public void setBodyMessage(Object bodyMessage) {
		this.bodyMessage = bodyMessage;
	}

	public long getSubCode() {
		return subCode;
	}

	public void setSubCode(long subCode) {
		this.subCode = subCode;
	}

	@Override
	public String toString() {
		return "ReturnModel [code=" + code + ", message=" + message + ", bodyMessage=" + bodyMessage + ", subCode="
				+ subCode + "]";
	}

}
