package com.coinMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.order.ShopCartModel;
import com.coinMall.bean.out.order.MyShopCartReturn;
import com.coinMall.service.ShopCartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** 
 * 购物车
 * @author jiangjiayi
 * @date 2018年10月24日
 */

@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="ShopCartController",description="购物车接口（移动端）")
public class ShopCartController {

	@Autowired
	private ShopCartService shopCartService;
	
	@ApiOperation(value="加入购物车",httpMethod="POST",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/addShopCart",method=RequestMethod.POST)
	public @ResponseBody ReturnModel addShopCart(@RequestBody ShopCartModel shopCartModel){
		return shopCartService.addShopCart(shopCartModel);
	}
	
	@ApiOperation(value="我的购物车",httpMethod="GET",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=MyShopCartReturn.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getMyShopCart",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getMyShopCart(
			@RequestParam(required=true)Integer uid){
		return shopCartService.getMyShopCart(uid);
	}
	
	@ApiOperation(value="加减购物车商品数量",httpMethod="PUT",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。<br/>"
			+ "3、code为0，subCode为700006时，表示加减数量操作异常，加减数量达到上下限，按钮需置灰限制用户操作。<br/>")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "cartId", required = true, value = "购物车ID", paramType = "query", dataType = "long"),
	      @ApiImplicitParam(name = "number", required = true, value = "加数量传1，减数量传-1", allowableValues="1,-1", paramType = "query", dataType = "int")})
	@RequestMapping(value="/updateCartTotal",method=RequestMethod.PUT)
	public @ResponseBody ReturnModel updateCartTotal(
			@RequestParam(required=true)Long cartId,
			@RequestParam(required=true)Integer number){
		return shopCartService.updateCartTotal(cartId, number);
	}
	
	@ApiOperation(value="统计购物车有效商品数量",httpMethod="GET",notes="1、该接口需根据返回的code和subCode进行逻辑判断，均为0时表示查询成功。<br/>"
			+ "2、code为0，subCode为700001时，表示传入的参数有问题，无法根据参数获取一些基本信息。")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=MyShopCartReturn.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "uid", required = true, value = "用户ID", paramType = "query", dataType = "int")})
	@RequestMapping(value="/getMyShopCartGoodsTotal",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getMyShopCartGoodsTotal(
			@RequestParam(required=true)Integer uid){
		return shopCartService.getMyShopCartGoodsTotal(uid);
	}
}
