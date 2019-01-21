package com.coinMall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.enums.CommentConst;
import com.coinMall.bean.enums.Subcode;
import com.coinMall.bean.in.comment.CommentImagesModel;
import com.coinMall.bean.in.comment.CommentModel;
import com.coinMall.bean.out.comment.CommentPageReturn;
import com.coinMall.bean.out.comment.CommentReturn;
import com.coinMall.bean.out.user.UserSmallModel;
import com.coinMall.common.BaseService;
import com.coinMall.dao.CommentMapper;
import com.coinMall.pojo.Comment;
import com.coinMall.service.CommentService;
import com.coinMall.util.CollectionUtil;

/** 
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@Service
public class CommentServiceImpl extends BaseService implements CommentService {

	private static Logger logger = Logger.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public ReturnModel addComment(CommentModel commentModel) {
		ReturnModel returnModel = new ReturnModel();
		try {
			Comment comment = new Comment();
			comment.setSourceId(CommentConst.COMMENT_SOURCE_COINMALL.getCode());
			comment.setAboutId(commentModel.getAboutId());
			comment.setUid(commentModel.getUid());
			comment.setParentId(commentModel.getParentId());
			comment.setCommentTime(new Date());
			comment.setCommentIp(commentModel.getCommentIp());
			comment.setIpArea(super.getLocationByIp(commentModel.getCommentIp()));
			comment.setCommentContent(commentModel.getCommentContent());
			comment.setCommentImages(commentModel.getCommentImagesModels() == null ? null : JSON.toJSONString(commentModel.getCommentImagesModels()));
			comment.setHaveImages(commentModel.getCommentImagesModels() == null ? 0 : 1);//是否有图，0-否 1-是
			comment.setCommentStatus(CommentConst.COMMENT_STATUS_DISPLAY_ON.getCode());
			comment.setPraiseTotal(0);
			comment.setReplyTotal(0);
			int insertSelective = commentMapper.insertSelective(comment);
			//如果是子评论，递增主评论的回复总数
			if(insertSelective > 0 && commentModel.getParentId() != null){
				commentMapper.updateReplyTotal(1, commentModel.getParentId());
			}
		} catch (Exception e) {
			logger.error("新增评论异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("新增评论异常");
		}
		return returnModel;
	}

	@Override
	public ReturnModel getCommentList(String aboutId, Integer uid, Long parentId, Integer pageIndex, Integer pageSize) {
		ReturnModel returnModel = new ReturnModel();
		try {
			//验证用户UID
			if(!verifyUser(uid)) return setModelError(returnModel, Subcode.PARAM_ERROR);
			
			List<Comment> comments = commentMapper.getCommentList(aboutId, uid, parentId, (pageIndex-1) * pageSize, pageSize);
			
			//批量查询用户信息
			Set<Integer> uids = new HashSet<>();
			for (Comment comment : comments) {
				uids.add(comment.getUid());
			}
			List<UserSmallModel> users = super.querySmallUserList(uids);
			Map<Integer, UserSmallModel> userMap = new CollectionUtil<Integer, UserSmallModel>().listToMap(users, "uid");
			
			List<CommentReturn> commentReturns = new ArrayList<>();
			for (Comment c : comments) {
				CommentReturn cr = buildCommentReturn(parentId, userMap, c);
				
				//子评论显示回复内容####暂时不做
				/*if(parentId != null){
					ReplyPageReturn replyPage = new ReplyPageReturn();
					replyPage.setReplys(replys);
					replyPage.setTotalCount(totalCount);
					cr.setReplyPage(replyPage);
				}*/
				
				commentReturns.add(cr);
			}
			//分页信息
			CommentPageReturn commentPageReturn = new CommentPageReturn();
			commentPageReturn.setPageDatas(commentReturns);
			commentPageReturn.setPageIndex(pageIndex);
			commentPageReturn.setPageSize(pageSize);
			int totalCount = commentMapper.getCommentListCount(aboutId, parentId);
			commentPageReturn.setTotalCount(totalCount);
			//commentPageReturn.setTotalPages((commentPagedCount+pageSize-1)/pageSize);
			
			//parentId不为空，查询主评论内容
			if(parentId != null){
				Comment parentComment = commentMapper.getParentCommentById(uid, parentId);
				Integer parentUid = parentComment.getUid();
				UserSmallModel pUser = super.querySmallUser(parentUid+"");
				if(pUser == null){
					return setModelError(returnModel, Subcode.BUSINESS_ERROR);
				}
				userMap.put(pUser.getUid(), pUser);
				CommentReturn mainComment = buildCommentReturn(parentId, userMap, parentComment);
				commentPageReturn.setMainComment(mainComment);
			}
			
			returnModel.setBodyMessage(JSON.toJSONString(commentPageReturn));
		} catch (Exception e) {
			logger.error("根据主题获取评论分页异常", e);
			returnModel.setCode(-1);
			returnModel.setMessage("根据主题获取评论分页异常");
		}
		return returnModel;
	}

	/**
	 * 组装评论内容
	 * @param parentId
	 * @param userMap
	 * @param c
	 * @return
	 */
	private CommentReturn buildCommentReturn(Long parentId, Map<Integer, UserSmallModel> userMap, Comment c) {
		CommentReturn cr = new CommentReturn();
		cr.setCommentId(c.getCommentId());
		cr.setAboutId(c.getAboutId());
		cr.setUid(c.getUid());
		cr.setParentId(c.getParentId());
		cr.setCommentTime(c.getCommentTime());
		cr.setCommentIp(c.getCommentIp());
		cr.setIpArea(c.getIpArea());
		cr.setCommentContent(c.getCommentContent());
		if(c.getCommentImages() != null){
			cr.setCommentImages(JSON.parseArray(c.getCommentImages(), CommentImagesModel.class));
		}
		cr.setCommentStatus(c.getCommentStatus());
		cr.setReplyTotal(c.getReplyTotal());
		cr.setPraiseTotal(c.getPraiseTotal());
		cr.setCommentType(parentId == null ? CommentConst.COMMENT_TYPE_MAIN.getCode() : CommentConst.COMMENT_TYPE_SUB.getCode());
		cr.setUser(userMap.get(c.getUid()));//用户信息
		cr.setIsPraised(c.getPraise().getPraiseId() == null ? 0 : 1);//用户对该评论是否点赞，0-否 1-是
		return cr;
	}

}
