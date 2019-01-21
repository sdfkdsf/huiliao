package com.coinMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.comment.CommentModel;
import com.coinMall.bean.out.comment.CommentPageReturn;
import com.coinMall.common.BaseController;
import com.coinMall.service.CommentService;
import com.coinMall.service.PraiseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** 
 * 评论和回复相关操作
 * @author jiangjiayi
 * @date 2018年10月16日
 */
@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="CommentReplyController",description="评论和回复相关操作（移动端）")
public class CommentReplyController extends BaseController{
	@Autowired
	private PraiseService praiseService;
	@Autowired
	private CommentService commentService;

	@ApiOperation(value="评论点赞",httpMethod="PUT",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "commentId", required = true, value = "评论ID", paramType = "query", dataType = "long"),
	      @ApiImplicitParam(name = "operateType", required = true, value = "操作类型（1：点赞；0：取消点赞）", allowableValues="1,0", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "praiseType", required = true, value = "点赞类型（1：主评；2：子评）", allowableValues="1,2", paramType = "query", dataType = "int")})
	@RequestMapping(value="/praiseComment",method=RequestMethod.PUT)
	public @ResponseBody ReturnModel praiseComment(
			@RequestParam(required=true)Integer uid, 
			@RequestParam(required=true)Long commentId, 
			@RequestParam(required=true)Integer operateType, 
			@RequestParam(required=true)Integer praiseType){
		return praiseService.praiseComment(uid, commentId, operateType, praiseType);
	}
	
	@ApiOperation(value="发表评论",httpMethod="POST",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public @ResponseBody ReturnModel addComment(@RequestBody CommentModel commentModel){
		return commentService.addComment(commentModel);
	}
	
	@ApiOperation(value="评论列表",httpMethod="GET",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=CommentPageReturn.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "aboutId", required = true, value = "主题ID", paramType = "query", dataType = "string"),
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "parentId", required = false, value = "主评ID，当查询子评时必传", paramType = "query", dataType = "long"),
	      @ApiImplicitParam(name = "pageIndex", required = false, value = "页码，默认第一页", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "pageSize", required = false, value = "页大小，默认20条", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getCommentList",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getCommentList(
			@RequestParam(required=true)String aboutId, 
			@RequestParam(required=true)Integer uid, 
			@RequestParam(required=false)Long parentId, 
			@RequestParam(defaultValue="1",required=false)Integer pageIndex, 
			@RequestParam(defaultValue="20",required=false)Integer pageSize){
		return commentService.getCommentList(aboutId, uid, parentId, pageIndex, pageSize);
	}
	
}
