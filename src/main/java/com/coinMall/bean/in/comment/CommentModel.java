package com.coinMall.bean.in.comment;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
public class CommentModel {
	
	@ApiModelProperty(value="主题ID",required=true)
	private String aboutId;
	
	@ApiModelProperty(value="用户ID",required=true,example="20163752")
	private Integer uid;
	
	@ApiModelProperty(value="主评论ID，当为子评论时必传",required=false,example="null")
	private Long parentId;
	
	@ApiModelProperty(value="评论用户IP",required=true,example="218.244.157.23")
	private String commentIp;
	
	@ApiModelProperty(value="评论文字内容",required=true)
	private String commentContent;
	
	@ApiModelProperty(value="评论图片",required=false)
	private List<CommentImagesModel> commentImagesModels;
	

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

	public String getCommentIp() {
		return commentIp;
	}

	public void setCommentIp(String commentIp) {
		this.commentIp = commentIp;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public List<CommentImagesModel> getCommentImagesModels() {
		return commentImagesModels;
	}

	public void setCommentImagesModels(List<CommentImagesModel> commentImagesModels) {
		this.commentImagesModels = commentImagesModels;
	}

}
