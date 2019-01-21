package com.coinMall.bean.out.user;

import io.swagger.annotations.ApiModelProperty;
/**
 * 用户扩展信息
 * @author Wayne.M
 * 2018年10月25日
 */
public class UserExpansionInfo {
	@ApiModelProperty(value="用户ID")
	private Integer uid;
	
	@ApiModelProperty(value="剩余金币总数")
	private double goldTotal;
	
	public double getGoldTotal() {
		return goldTotal;
	}
	public void setGoldTotal(double goldTotal) {
		this.goldTotal = goldTotal;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
