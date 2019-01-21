package com.coinMall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.GoodsModel;
import com.coinMall.common.BaseController;
import com.coinMall.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



/** 
 * 评论和回复相关操作
 * @author wubingqiao
 * @date 2018年10月16日
 */
@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="goodsController",description="商品管理API（移动端调用）")
public class GoodsController extends BaseController {
	
	@Autowired
	private GoodsService goodsService;
	
	/**
     *     获得  所有的商品
     * @param pageIndex
     * @param pageSize
     * @return
     */
	@ApiOperation(value="获取所有商品")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "pageIndex", required = false, defaultValue= "1", value = "第几页", paramType = "query", dataType = "int"),
	      @ApiImplicitParam(name = "pageSize", required = false, defaultValue= "10", value = "每页多少商品信息", paramType = "query", dataType = "int"),
	      })
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getGoodsList(
            @RequestParam(defaultValue="1",required=false)Integer pageIndex,
            @RequestParam(defaultValue="10",required=false)Integer pageSize
			){
		return goodsService.getList(pageIndex,pageSize);
	}

    /**
     *     批量删除商品信息
     * @param idList
     * @return
     */
    @ApiOperation(value="删除多个商品")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})

    @RequestMapping(value="/delect",method=RequestMethod.POST)
    public @ResponseBody ReturnModel delect(
            @RequestParam(value = "idList") @ApiParam(value = "需要删除多个商品的ID,需要一个删除商品ID 的集合") List<Long> idList
    ){
        return goodsService.delete(idList);
    }

    /**
     *      查询某一个商品
     * @param goodsId
     * @return
     */
    @ApiOperation(value="查询某一个商品")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", required = true,  value = "商品ID", paramType = "query", dataType = "long"),
    })
    @RequestMapping(value="/getOne",method=RequestMethod.GET)
    public @ResponseBody ReturnModel getOneByGoodsId(
            @RequestParam(required=true)Long goodsId
    ){
        return goodsService.getOneByGoodsId(goodsId);
    }


    /***
     *     添加一个商品    或者    修改一个商品
     * @param goods
     * @return
     */
    @ApiOperation(value="添加一个商品（不带商品id）    或者      修改商品  （必须携带商品id）   ")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response = ReturnModel.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name =  "goodsId", required = true,  value = "商品ID", paramType = "query", dataType = "long"),
    })
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public @ResponseBody ReturnModel InsertGoods(
            @RequestBody GoodsModel goodsModel
            ){
        return goodsService.InsertGoods(goodsModel);
    }

}
