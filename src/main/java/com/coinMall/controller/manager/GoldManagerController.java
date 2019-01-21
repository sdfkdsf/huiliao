package com.coinMall.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.gold.PlatformInfoRequest;
import com.coinMall.common.BaseController;
import com.coinMall.service.GoldObtainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Controller
@RequestMapping(value="/api/manager", produces={"application/json;charset=UTF-8"})
@Api(tags="GoldManagerController",description="金币管理API（后台管理系统）")
public class GoldManagerController extends BaseController {
	@Autowired
	private GoldObtainService goldObtainService;
	
	@ApiOperation(value="查询平台及平台的金币数",httpMethod = "GET")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/getPlatformInfoList",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getPlatformInfoList(){
		return goldObtainService.getPlatformInfoList();
	}
	
	@ApiOperation(value="添加或修改平台信息",httpMethod = "POST",notes=""
			+ "1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示添加或修改成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，请确认传入的参数符合要求。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/addPlatformInfo",method=RequestMethod.POST)
	public @ResponseBody ReturnModel addPlatformInfo(@RequestBody PlatformInfoRequest rq){
		return goldObtainService.addPlatformInfo(rq);
	}
	
	@ApiOperation(value="平台充值",httpMethod = "PUT",notes=""
			+ "1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示添加或修改成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，请确认传入的参数符合要求。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "platformId", required = true, value = "平台ID", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "amount", required = true, value = "充值金额", paramType = "query", dataType = "double")})
	@RequestMapping(value="/platformRecharge",method=RequestMethod.PUT)
	public @ResponseBody ReturnModel platformRecharge(
			@RequestParam(required=true)Integer platformId,
			@RequestParam(required=true)double amount){
		return goldObtainService.platformRecharge(platformId,amount,getIpAddr(requestThreadLocal.get()));
	}
}
