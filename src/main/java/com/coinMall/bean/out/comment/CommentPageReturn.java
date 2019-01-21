package com.coinMall.bean.out.comment;

import com.coinMall.bean.PageModel;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月17日
 */
public class CommentPageReturn extends PageModel<CommentReturn> {
	
	@ApiModelProperty(value="主评论数据，查询子评论时返回")
	private CommentReturn mainComment;
	
	public CommentReturn getMainComment() {
		return mainComment;
	}
	public void setMainComment(CommentReturn mainComment) {
		this.mainComment = mainComment;
	}
}
