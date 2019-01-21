package com.coinMall.bean.in.order;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月24日
 */
public class ShopCartModel {

	@ApiModelProperty(value = "用户ID")
	private Integer uid;
	@ApiModelProperty(value = "商品ID")
	private Long goodsId;
	@ApiModelProperty(value = "商品规格库存ID")
	private Long stockId;
	@ApiModelProperty(value = "数量")
	private Integer cartTotal;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public Integer getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(Integer cartTotal) {
		this.cartTotal = cartTotal;
	}
}
