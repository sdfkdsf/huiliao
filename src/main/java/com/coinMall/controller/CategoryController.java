package com.coinMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.CategoryModel;
import com.coinMall.common.BaseController;
import com.coinMall.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月25日 下午2:14:52 
* 类说明 
*/

@Controller
@RequestMapping(value="/api", produces={"application/json;charset=UTF-8"})
@Api(tags="CategoryController",description="分类管理API（后台管理系统）")
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;
	
	
	/**
	 *    	得到这个   分类下的所有子类层级;  
	 *    
	 * @param goodsModel
	 * @return
	 */
	@ApiOperation(value="得到这个分类下的所有子类层级,传入categoryId ")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response = ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "categoryId", required = true, value = "分类Id", paramType = "query", dataType = "int")
	      })
	
    @RequestMapping(value="/getAllSonCategory",method=RequestMethod.GET)
    public @ResponseBody ReturnModel getAllSonCategory(
    		@RequestParam(required=true)Integer categoryId
            ){
        return categoryService.getAllSonCategory(categoryId);
    }
	
	
	/**
	 *    	删除一个分类信息
	 *    
	 * @param goodsModel
	 * @return
	 */
	@ApiOperation(value="删除一个分类,传入categoryId ")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response = ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "categoryId", required = true, value = "分类Id", paramType = "query", dataType = "int")
	      })
	
    @RequestMapping(value="/deleteCategory",method=RequestMethod.GET)
    public @ResponseBody ReturnModel deleteCategory(
    		@RequestParam(required=true)Integer categoryId
            ){
        return categoryService.deleteCategory(categoryId);
    }
	
	
	/**
	 *      根据层级得到分组信息
	 * @param categoryLevel
	 * @return
	 */
	@ApiOperation(value="根据层级得到分类信息")
	@ApiResponses({@ApiResponse(code = 200, message = "ok", response=ReturnModel.class)})
	@ApiImplicitParams({
	      @ApiImplicitParam(name = "categoryLevel", required = true, value = "分类层级", paramType = "query", dataType = "int")
	      })
	@RequestMapping(value="/getCategorysByLevel",method=RequestMethod.GET)
	public @ResponseBody ReturnModel getCategorysByLevel(
			@RequestParam(required=true)Integer categoryLevel
			){
		return categoryService.getCategorysByLevel(categoryLevel);
	}
	
	/***
     *     添加一个分类    
     * @param goods
     * @return
     */
    @ApiOperation(value="添加一个分类  ，不携带categoryId）   ")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response = ReturnModel.class)})
    
    @RequestMapping(value="/addCategory",method=RequestMethod.POST)
    public @ResponseBody ReturnModel addCategory(
            @RequestBody CategoryModel goodsModel
            ){
        return categoryService.addCategory(goodsModel);
    }
    
    /***
     *     修改一个    分类   信息
     * @param goods
     * @return
     */
  /*  @ApiOperation(value="修改一个分类  ，必须携带   categoryId）   ")
    @ApiResponses({@ApiResponse(code = 200, message = "ok", response = ReturnModel.class)})
    
    @RequestMapping(value="/updateCategory",method=RequestMethod.POST)
    public @ResponseBody ReturnModel updateCategory(
            @RequestBody CategoryModel goodsModel
            ){
        return categoryService.addCategory(goodsModel);
    }
	*/
	
}
