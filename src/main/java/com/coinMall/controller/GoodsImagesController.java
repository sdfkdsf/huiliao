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
import com.coinMall.bean.in.goods.GoodsImagesModel;
import com.coinMall.bean.in.user.ReceiptInfoModel;
import com.coinMall.common.BaseController;
import com.coinMall.service.GoodsImagesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月24日 下午5:53:39 
* 类说明 
*/
@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="GoodsImagesController",description="图片管理API（后台管理系统）")
public class GoodsImagesController extends BaseController{

	@Autowired
	private GoodsImagesService goodsImagesService;
	
	 @ApiOperation(value="查询某一个商品的所有照片")
	    @ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	    @ApiImplicitParams({
	            @ApiImplicitParam(name = "goodsId", required = true,  value = "商品ID", paramType = "query", dataType = "long"),
	    })
	    @RequestMapping(value="/getGoodsImages",method=RequestMethod.GET)
	    public @ResponseBody ReturnModel getOneByGoodsId(
	            @RequestParam(required=true)Long goodsId
	    ){
	        return goodsImagesService.getImagesByGoodsId(goodsId);
	    }
	
	/**
     *     批量删除商品图片
     * @param idList
     * @return
     */
    @ApiOperation(value="删除多个商品图片，传入      图片Id goodsImagesId ")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})

    @RequestMapping(value="/delectGoodsImages",method=RequestMethod.POST)
    public @ResponseBody ReturnModel delectGoodsImages(
//            @RequestParam(value = "idList") @ApiParam(value = "需要删除多个商品的图片,需要传送商品 ID 的集合") List<Long> idList
            @RequestParam(value = "idList") List<Integer> idList
    ){
        return goodsImagesService.delete(idList);
    }
	
	 /***
     *     添加一个商品    的   图片
     * @param goods
     * @return
     */
    @ApiOperation(value="增加商品图片")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@RequestMapping(value="/addGoodsImages",method=RequestMethod.POST)
	public @ResponseBody ReturnModel addGoodsImages(@RequestBody GoodsImagesModel goodsImagesModel){
		return goodsImagesService.addGoodsImages(goodsImagesModel);
	}
    
   
}










































