package com.coinMall.bean.out.comment;

import java.util.Date;
import java.util.List;

import com.coinMall.bean.in.comment.CommentImagesModel;
import com.coinMall.bean.out.user.UserSmallModel;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月17日
 */
public class CommentReturn {

	@ApiModelProperty(value="评论ID")
	private Long commentId;
	@ApiModelProperty(value="评论相关主题ID")
	private String aboutId;
	@ApiModelProperty(value="评论用户ID")
	private Integer uid;
	@ApiModelProperty(value="主评论ID")
	private Long parentId;
	@ApiModelProperty(value="评论时间")
	private Date commentTime;
	@ApiModelProperty(value="评论IP")
	private String commentIp;
	@ApiModelProperty(value="IP所在地区")
	private String ipArea;
	@ApiModelProperty(value="评论内容")
	private String commentContent;
	@ApiModelProperty(value="评论图片")
	private List<CommentImagesModel> commentImages;
	@ApiModelProperty(value="评论状态")
	private Integer commentStatus;
	@ApiModelProperty(value="回复总数")
	private Integer replyTotal;
	@ApiModelProperty(value="点赞总数")
	private Integer praiseTotal;
	
	//##暂时不做回复
	/*@ApiModelProperty(value="评论回复")
	private ReplyPageReturn replyPage;*/
	@ApiModelProperty(value="评论类型1-主评论，2-子评论")
	private Integer commentType;
	@ApiModelProperty(value="评论用户")
	private UserSmallModel user;
	@ApiModelProperty(value="针对该条评论我是否已经点赞过")
	private Integer isPraised;
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getAboutId() {
		return aboutId;
	}
	public void setAboutId(String aboutId) {
		this.aboutId = aboutId;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentIp() {
		return commentIp;
	}
	public void setCommentIp(String commentIp) {
		this.commentIp = commentIp;
	}
	public String getIpArea() {
		return ipArea;
	}
	public void setIpArea(String ipArea) {
		this.ipArea = ipArea;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public List<CommentImagesModel> getCommentImages() {
		return commentImages;
	}
	public void setCommentImages(List<CommentImagesModel> commentImages) {
		this.commentImages = commentImages;
	}
	public Integer getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
	}
	public Integer getReplyTotal() {
		return replyTotal;
	}
	public void setReplyTotal(Integer replyTotal) {
		this.replyTotal = replyTotal;
	}
	public Integer getPraiseTotal() {
		return praiseTotal;
	}
	public void setPraiseTotal(Integer praiseTotal) {
		this.praiseTotal = praiseTotal;
	}
	public Integer getCommentType() {
		return commentType;
	}
	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}
	public UserSmallModel getUser() {
		return user;
	}
	public void setUser(UserSmallModel user) {
		this.user = user;
	}
	public Integer getIsPraised() {
		return isPraised;
	}
	public void setIsPraised(Integer isPraised) {
		this.isPraised = isPraised;
	}
	
}
