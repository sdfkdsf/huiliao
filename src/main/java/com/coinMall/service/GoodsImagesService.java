package com.coinMall.service;

import java.util.List;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.GoodsImagesModel;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月24日 下午5:57:09 
* 类说明 
*/
public interface GoodsImagesService {

	/**
	 *     增加   商品的  图片信息
	 * @param goodsImagesModel
	 * @return
	 */
	ReturnModel addGoodsImages(GoodsImagesModel goodsImagesModel);

	/**
	 *      删除多个商品  图片
	 * @param idList
	 * @return
	 */
	
	ReturnModel delete(List<Integer> idList);

	/**
	 *    查询  这个  商品的   所有图片
	 * @param goodsId
	 * @return
	 */
	ReturnModel getImagesByGoodsId(Long goodsId);

}
