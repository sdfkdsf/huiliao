package com.coinMall.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.enums.CommentConst;
import com.coinMall.bean.enums.Subcode;
import com.coinMall.common.BaseService;
import com.coinMall.dao.CommentMapper;
import com.coinMall.dao.PraiseMapper;
import com.coinMall.pojo.Praise;
import com.coinMall.service.PraiseService;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@Service
public class PraiseServiceImpl extends BaseService implements PraiseService {
	
	private static Logger logger = Logger.getLogger(PraiseServiceImpl.class);
	
	@Autowired
	private PraiseMapper praiseMapper;
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public ReturnModel praiseComment(Integer uid, Long commentId, Integer operateType, Integer praiseType) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(returnModel, Subcode.PARAM_ERROR);
			if(praiseType != CommentConst.COMMENT_TYPE_MAIN.getCode() && praiseType != CommentConst.COMMENT_TYPE_SUB.getCode()){
				return setModelError(returnModel, Subcode.PARAM_ERROR);
			}
			
			if(operateType == CommentConst.PRAISE_YES.getCode()){//点赞
				Praise praise = new Praise();
				praise.setCommentId(commentId);
				praise.setUid(uid);
				praise.setPraiseType(praiseType);
				int insertSelective = praiseMapper.insertSelective(praise);
				if(insertSelective > 0){
					commentMapper.updatePraiseTotal(1, commentId);//递增点赞总数
				}
			}else if(operateType == CommentConst.PRAISE_NO.getCode()){//取消点赞
				int deleteRecord = praiseMapper.deleteRecord(commentId, uid, praiseType);
				if(deleteRecord > 0){
					commentMapper.updatePraiseTotal(-1, commentId);//递减点赞总数
				}
			}else{
				return setModelError(returnModel, Subcode.PARAM_ERROR);
			}
		} catch (Exception e) {
			logger.error("评论点赞异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("评论点赞异常");
		}
		return returnModel;
	}

	
}
