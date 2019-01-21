package com.coinMall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.common.BaseController;
import com.coinMall.service.GoldObtainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 金币赠送API接口,服务端内部调用
 * @author Wayne.M
 * 2018年10月25日
 */
@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="GoldObtainController",description="金币赠送API（服务端内部调用）")
public class GoldObtainController extends BaseController {
	@Autowired
	private GoldObtainService goldObtainService;
	
	@ApiOperation(value="赠送金币",httpMethod = "PUT",notes=""
			+ "1、该接口需根据返回的code和subCode进行逻辑判断，均为0时赠送金币成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。<br/>"
			+ "3、code为0，subCode为700003时，表示金币已经赠送过或已不满足赠送条件。<br/>"
			+ "4、code为0，subCode为700004时，表示平台金币已不足，无法满足赠送条件。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "rule_id", required = true, value = "充值规则ID", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "md5_key", required = true, value = "MD5 key值", paramType = "query", dataType = "string"),
	      @ApiImplicitParam(name = "timestamp", required = true, value = "13位时间撮", paramType = "query", dataType = "string")})
	@RequestMapping(value="/obtainGold",method=RequestMethod.PUT)
	public @ResponseBody ReturnModel obtainGold(
			@RequestParam(required=true)Integer uid,
			@RequestParam(required=true)Integer rule_id,
			@RequestParam(required=true)String md5_key,
			@RequestParam(required=true)String timestamp){
		return goldObtainService.obtainGold(uid, rule_id, md5_key.trim(), timestamp.trim());
	}
}
