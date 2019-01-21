package com.coinMall.service;

import com.coinMall.bean.ReturnModel;
import com.coinMall.bean.in.order.ShopCartModel;

/** 
 * @author jiangjiayi
 * @date 2018年10月24日
 */
public interface ShopCartService {

	/**
	 * 加入购物车
	 * @param shopCartModel
	 * @return
	 */
	ReturnModel addShopCart(ShopCartModel shopCartModel);
	
	/**
	 * 我的购物车
	 * @param uid
	 * @return
	 */
	ReturnModel getMyShopCart(Integer uid);

	/**
	 * 加减购物车商品数量
	 * @param cartId
	 * @param number
	 * @return
	 */
	ReturnModel updateCartTotal(Long cartId, Integer number);
	
	/**
	 * 统计购物车有效商品数量
	 * @param uid
	 * @return
	 */
	ReturnModel getMyShopCartGoodsTotal(Integer uid);
	
}
