package com.coinMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.out.gold.GoldLogModel;
import com.coinMall.bean.out.user.UserExpansionInfo;
import com.coinMall.common.BaseController;
import com.coinMall.service.GoldObtainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 金币查询API,移动端调用
 * @author Wayne.M
 * 2018年10月25日
 */
@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="GoldLogController",description="金币查询API（移动端调用）")
public class GoldLogController extends BaseController {
	@Autowired
	private GoldObtainService goldObtainService;
	
	@ApiOperation(value="根据用户ID查询用户金币总数",httpMethod = "GET",notes=""
			+ "1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=UserExpansionInfo.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getGoldByUserId",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getGoldByUserId(@RequestParam(required=true)Integer uid){
		return goldObtainService.getGoldByUserId(uid);
	}
	
	@ApiOperation(value="根据用户ID分页查询平台金币赠送日志",httpMethod = "GET",notes=""
			+ "1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=GoldLogModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "pageIndex", required = false, value = "页码，默认1", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "pageSize", required = false, value = "页大小，默认20", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getGoldLogOfPage",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getGoldLogOfPage(
			@RequestParam(required=true)Integer uid,
			@RequestParam(defaultValue="1",required=false)Integer pageIndex,
			@RequestParam(defaultValue="20",required=false)Integer pageSize){
		return goldObtainService.getGoldLogOfPage(uid,pageIndex,pageSize);
	}
}
