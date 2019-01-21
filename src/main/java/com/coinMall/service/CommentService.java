package com.coinMall.service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.comment.CommentModel;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
public interface CommentService {

	/**
	 * 新增评论
	 * @param commentModel
	 * @param ip
	 * @return
	 */
	public ReturnModel addComment(CommentModel commentModel);

	/**
	 * 评论列表
	 * @param aboutId
	 * @param uid
	 * @param parentId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ReturnModel getCommentList(String aboutId, Integer uid, Long parentId, Integer pageIndex, Integer pageSize);
	
}
