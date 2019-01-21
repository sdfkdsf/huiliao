package com.coinMall.bean.in.gold;

import io.swagger.annotations.ApiModelProperty;

public class PlatformInfoRequest {
	@ApiModelProperty(value = "平台ID，如果是修改必传")
	private Integer platformId;
	@ApiModelProperty(value = "平台名称")
    private String platformName;
	@ApiModelProperty(value = "平台类型,1：自有平台，2：交易商平台")
    private Integer platformType;
	@ApiModelProperty(value = "平台金币数")
    private Double platformGold;

    public Integer getPlatformId() {
        return platformId;
    }

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public Integer getPlatformType() {
		return platformType;
	}

	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}

	public Double getPlatformGold() {
		return platformGold;
	}

	public void setPlatformGold(Double platformGold) {
		this.platformGold = platformGold;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
}
