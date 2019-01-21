package com.coinMall.service;

import java.util.List;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.goods.GoodsModel;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月23日 下午2:21:40 
* 类说明 
*/
public interface GoodsService {

	/**
	 *  获得所有的我们的商品信息
	 * @return
	 * @param pageIndex
	 * @param pageSize
	 */
	ReturnModel getList(Integer pageIndex, Integer pageSize);

	/**
	 *    删除多个   商品商品
	 * @param idList
	 * @return
	 */
	ReturnModel delete(List<Long> idList);

	/**
	 *    根据  商品的  Id  得到商品的信息
	 * @param goodsId
	 * @return
	 */
	ReturnModel getOneByGoodsId(Long goodsId);

	/**
	 *   添加一个商品信息
	 * @param goods
	 * @return
	 */
    ReturnModel InsertGoods(GoodsModel goods);

}
