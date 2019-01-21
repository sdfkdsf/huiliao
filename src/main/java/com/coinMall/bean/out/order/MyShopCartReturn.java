package com.coinMall.bean.out.order;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月24日
 */
public class MyShopCartReturn {

	@ApiModelProperty(value="我的金币")
	private Double myGold;
	@ApiModelProperty(value="商品列表")
	private List<ShopCartReturn> shopCartList;
	
	
	public static class ShopCartReturn{
		@ApiModelProperty(value="购物车ID")
		private Long cartId;
		@ApiModelProperty(value="商品缩略图")
		private String goodsImg;
		@ApiModelProperty(value="商品名称")
		private String goodsName;
		@ApiModelProperty(value="规格")
		private String normValue;
		@ApiModelProperty(value="所需金币")
		private Double stockGold;
		@ApiModelProperty(value="数量")
		private Integer cartTotal;
		@ApiModelProperty(value="是否有效商品(0-无效，1-有效)")
		private Integer isValidGoods;
		@ApiModelProperty(value="商品ID")
		private Long goodsId;
		@ApiModelProperty(value="商品金币小计")
		private Double stockGoldSubtotal;
		
		public Long getCartId() {
			return cartId;
		}
		public void setCartId(Long cartId) {
			this.cartId = cartId;
		}
		public String getGoodsImg() {
			return goodsImg;
		}
		public void setGoodsImg(String goodsImg) {
			this.goodsImg = goodsImg;
		}
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public String getNormValue() {
			return normValue;
		}
		public void setNormValue(String normValue) {
			this.normValue = normValue;
		}
		public Double getStockGold() {
			return stockGold;
		}
		public void setStockGold(Double stockGold) {
			this.stockGold = stockGold;
		}
		public Integer getCartTotal() {
			return cartTotal;
		}
		public void setCartTotal(Integer cartTotal) {
			this.cartTotal = cartTotal;
		}
		public Integer getIsValidGoods() {
			return isValidGoods;
		}
		public void setIsValidGoods(Integer isValidGoods) {
			this.isValidGoods = isValidGoods;
		}
		public Long getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(Long goodsId) {
			this.goodsId = goodsId;
		}
		public Double getStockGoldSubtotal() {
			return stockGoldSubtotal;
		}
		public void setStockGoldSubtotal(Double stockGoldSubtotal) {
			this.stockGoldSubtotal = stockGoldSubtotal;
		}
	}
	
	
	public Double getMyGold() {
		return myGold;
	}
	public void setMyGold(Double myGold) {
		this.myGold = myGold;
	}
	public List<ShopCartReturn> getShopCartList() {
		return shopCartList;
	}
	public void setShopCartList(List<ShopCartReturn> shopCartList) {
		this.shopCartList = shopCartList;
	}
}
