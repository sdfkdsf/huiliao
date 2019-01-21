package com.coinMall.service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.CategoryModel;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月23日 上午11:12:45 
* 类说明 
*/
public interface CategoryService {

	/***
	 *      通过层级    来的大我们   所有的     分类信息
	 * @param categoryLevel
	 * @return
	 */
	ReturnModel getCategorysByLevel(Integer categoryLevel);

	/**
	 *      添加一个分类信息
	 * @param goodsModel
	 * @return
	 */
	ReturnModel addCategory(CategoryModel goodsModel);
	
	/***
	 *     删除某一个分类
	 * @param categoryId
	 * @return
	 */
	ReturnModel deleteCategory(Integer categoryId);

	/***
	 *    得到这个层级下面所有的子类  分类;
	 * @param categoryId
	 * @return
	 */
	ReturnModel getAllSonCategory(Integer categoryId);

}
