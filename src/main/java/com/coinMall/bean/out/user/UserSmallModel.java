package com.coinMall.bean.out.user;

import io.swagger.annotations.ApiModelProperty;

/** 
 * 用户缩略模型
 * @author jiangjiayi
 * @date 2018年10月17日
 */
public class UserSmallModel {

	@ApiModelProperty(value="用户ID")
	private Integer uid;
	@ApiModelProperty(value="昵称")
	private String nickName;
	@ApiModelProperty(value="头像")
	private String userHeadImage;
	@ApiModelProperty(value="头像48")
	private String userHeadImg_48;
	@ApiModelProperty(value="头像80")
	private String userHeadImg_80;
	@ApiModelProperty(value="头像120")
	private String userHeadImg_120;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserHeadImage() {
		return userHeadImage;
	}
	public void setUserHeadImage(String userHeadImage) {
		this.userHeadImage = userHeadImage;
	}
	public String getUserHeadImg_48() {
		return userHeadImg_48;
	}
	public void setUserHeadImg_48(String userHeadImg_48) {
		this.userHeadImg_48 = userHeadImg_48;
	}
	public String getUserHeadImg_80() {
		return userHeadImg_80;
	}
	public void setUserHeadImg_80(String userHeadImg_80) {
		this.userHeadImg_80 = userHeadImg_80;
	}
	public String getUserHeadImg_120() {
		return userHeadImg_120;
	}
	public void setUserHeadImg_120(String userHeadImg_120) {
		this.userHeadImg_120 = userHeadImg_120;
	}
	@Override
	public String toString() {
		return "UserSmallModel [uid=" + uid + ", nickName=" + nickName + ", userHeadImage=" + userHeadImage
				+ ", userHeadImg_48=" + userHeadImg_48 + ", userHeadImg_80=" + userHeadImg_80 + ", userHeadImg_120="
				+ userHeadImg_120 + "]";
	}
}
