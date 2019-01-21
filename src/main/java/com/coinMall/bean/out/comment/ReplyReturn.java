package com.coinMall.bean.out.comment;

import java.util.Date;
import java.util.List;

import com.coinMall.bean.in.comment.ReplyImagesModel;
import com.coinMall.bean.out.user.UserSmallModel;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月17日
 */
public class ReplyReturn {

	@ApiModelProperty(value="回复ID")
	private Long replyId;
	@ApiModelProperty(value="评论ID")
	private Long commentId;
	@ApiModelProperty(value="艾特的UID")
	private Integer atUid;
	@ApiModelProperty(value="艾特的用户")
	private UserSmallModel atUser;
	@ApiModelProperty(value="回复内容")
	private String replyContent;
	@ApiModelProperty(value="回复时间")
	private Date replyTime;
	@ApiModelProperty(value="回复图片")
	private List<ReplyImagesModel> replyImagesModels;
	@ApiModelProperty(value="回复IP")
	private String replyIp;
	@ApiModelProperty(value="IP所在地区")
	private String ipArea;
	@ApiModelProperty(value="回复状态")
	private Integer replyStatus;
	@ApiModelProperty(value="评论用户ID")
	private Integer uid;
	@ApiModelProperty(value="评论用户")
	private UserSmallModel user;
	
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Integer getAtUid() {
		return atUid;
	}
	public void setAtUid(Integer atUid) {
		this.atUid = atUid;
	}
	public UserSmallModel getAtUser() {
		return atUser;
	}
	public void setAtUser(UserSmallModel atUser) {
		this.atUser = atUser;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public List<ReplyImagesModel> getReplyImagesModels() {
		return replyImagesModels;
	}
	public void setReplyImagesModels(List<ReplyImagesModel> replyImagesModels) {
		this.replyImagesModels = replyImagesModels;
	}
	public String getReplyIp() {
		return replyIp;
	}
	public void setReplyIp(String replyIp) {
		this.replyIp = replyIp;
	}
	public String getIpArea() {
		return ipArea;
	}
	public void setIpArea(String ipArea) {
		this.ipArea = ipArea;
	}
	public Integer getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public UserSmallModel getUser() {
		return user;
	}
	public void setUser(UserSmallModel user) {
		this.user = user;
	}
}
