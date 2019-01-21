package com.coinMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.user.ReceiptInfoModel;
import com.coinMall.bean.out.user.ReceiptInfoReturn;
import com.coinMall.service.ReceiptInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** 
 * @author jiangjiayi
 * @date 2018年10月19日
 */
@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="ReceiptInfoController",description="收货地址相关操作（移动端）")
public class ReceiptInfoController {

	@Autowired
	private ReceiptInfoService receiptInfoService;
	
	@ApiOperation(value="新增收货地址",httpMethod="POST",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/addReceiptInfo",method=RequestMethod.POST)
	public @ResponseBody ReturnModel addReceiptInfo(@RequestBody ReceiptInfoModel receiptInfoModel){
		return receiptInfoService.addReceiptInfo(receiptInfoModel);
	}
	
	@ApiOperation(value="查询我的收到地址列表",httpMethod="GET",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReceiptInfoReturn.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getReceiptInfoList",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getReceiptInfoList(
			@RequestParam(required=true)Integer uid){
		return receiptInfoService.getReceiptInfoList(uid);
	}
	
	@ApiOperation(value="根据id查询收货地址详情",httpMethod="GET",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReceiptInfoReturn.class)})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "receiptId", required = true, value = "ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getReceiptInfoById",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getReceiptInfoById(@RequestParam(required=true)Integer receiptId){
		return receiptInfoService.getReceiptInfoById(receiptId);
	}
	
	@ApiOperation(value="修改收货地址",httpMethod="POST",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/updateReceiptInfo",method=RequestMethod.POST)
	public @ResponseBody ReturnModel updateReceiptInfo(@RequestBody ReceiptInfoModel receiptInfoModel){
		return receiptInfoService.updateReceiptInfo(receiptInfoModel);
	}
	
	@ApiOperation(value="根据id删除收货地址",httpMethod="DELETE",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "receiptId", required = true, value = "ID", paramType = "query", dataType = "int"),
		@ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/deleteReceiptInfoById",method=RequestMethod.DELETE)
	public @ResponseBody ReturnModel deleteReceiptInfoById(
			@RequestParam(required=true)Integer receiptId,
			@RequestParam(required=true)Integer uid){
		return receiptInfoService.deleteReceiptInfoById(receiptId, uid);
	}
	
	@ApiOperation(value="根据用户ID查询默认地址",httpMethod="GET",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。<br/>"
			+ "3、code为0，subCode为700005时，表示未查询到默认收货地址，需跳转到添加收货地址页面。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReceiptInfoReturn.class)})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getReceiptDefaultByUid",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getReceiptDefaultByUid(@RequestParam(required=true)Integer uid){
		return receiptInfoService.getReceiptDefaultByUid(uid);
	}
}
