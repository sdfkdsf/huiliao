package com.coinMall.bean.in.comment;

import io.swagger.annotations.ApiModelProperty;

public class CommentImagesModel {
	
	@ApiModelProperty(value = "小图")
	private String smallImg;
	
	@ApiModelProperty(value = "大图")
	private String bigImg;
	
	@ApiModelProperty(value = "描述")
	private String description;

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}