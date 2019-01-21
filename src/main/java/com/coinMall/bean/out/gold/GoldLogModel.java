package com.coinMall.bean.out.gold;

import io.swagger.annotations.ApiModelProperty;
/**
 * 金币日志记录输出模型
 * @author Wayne.M
 * 2018年10月25日
 */
public class GoldLogModel {
	@ApiModelProperty(value="唯一ID")
	private Long obtainId;
	@ApiModelProperty(value="13位时间撮")
	private Long obtainTime;
	@ApiModelProperty(value="赠送或消费金币值")
	private Double obtainGold;
	@ApiModelProperty(value="赠送或消费说明")
	private String obtainDescription;
	public Long getObtainTime() {
		return obtainTime;
	}
	public void setObtainTime(Long obtainTime) {
		this.obtainTime = obtainTime;
	}
	public Double getObtainGold() {
		return obtainGold;
	}
	public void setObtainGold(Double obtainGold) {
		this.obtainGold = obtainGold;
	}
	public String getObtainDescription() {
		return obtainDescription;
	}
	public void setObtainDescription(String obtainDescription) {
		this.obtainDescription = obtainDescription;
	}
	public Long getObtainId() {
		return obtainId;
	}
	public void setObtainId(Long obtainId) {
		this.obtainId = obtainId;
	}
}
