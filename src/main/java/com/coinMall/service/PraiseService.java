package com.coinMall.service;

import com.coinMall.bean.ReturnModel;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
public interface PraiseService {

	/**
	 * 评论点赞
	 * @param uid
	 * @param comment_id
	 * @param operateType
	 * @param praiseType
	 * @return
	 */
	public ReturnModel praiseComment(Integer uid, Long comment_id, Integer operateType, Integer praiseType);
}
