package com.coinMall.bean.in.goods;

import io.swagger.annotations.ApiModelProperty;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月24日 下午5:09:42 
* 类说明 
*/
public class GoodsImagesModel {
	   
		@ApiModelProperty(value="商品的Id",required = true)
	    private Long goodsId;
		@ApiModelProperty(value="图片地址",required = true)
	    private String imagesSrc;
		
		@ApiModelProperty(value="是否显示，默认为显示，显示为1，不显示为0",required = false,allowableValues = "1")	   
	    private Integer imagesDisplay;
		
		@ApiModelProperty(value="商品说明",required = false)
	    private String imagesDescirption;

		public Long getGoodsId() {
			return goodsId;
		}

		public void setGoodsId(Long goodsId) {
			this.goodsId = goodsId;
		}

		public String getImagesSrc() {
			return imagesSrc;
		}

		public void setImagesSrc(String imagesSrc) {
			this.imagesSrc = imagesSrc;
		}

		public Integer getImagesDisplay() {
			return imagesDisplay;
		}

		public void setImagesDisplay(Integer imagesDisplay) {
			this.imagesDisplay = imagesDisplay;
		}

		public String getImagesDescirption() {
			return imagesDescirption;
		}

		public void setImagesDescirption(String imagesDescirption) {
			this.imagesDescirption = imagesDescirption;
		}

		
	    
}
