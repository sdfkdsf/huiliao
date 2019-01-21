package com.coinMall.bean.out.goods;

import io.swagger.annotations.ApiModelProperty;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月24日 下午5:46:15 
* 类说明 
*/
public class GoodsImagesReturn {
	@ApiModelProperty(value="商品图片的Id")
	private Integer imagesId;

	@ApiModelProperty(value="商品的Id")
    private Long goodsId;
	@ApiModelProperty(value="图片地址")
    private String imagesSrc;
	
	@ApiModelProperty(value="图片排序")
	private Integer imagesSort;
	
	@ApiModelProperty(value="是否显示，默认为显示，显示为1，不显示为0")	   
    private Integer imagesDisplay;
	
	@ApiModelProperty(value="图片说明，可能为null")
    private String imagesDescirption;

	
	
	public Integer getImagesId() {
		return imagesId;
	}

	public void setImagesId(Integer imagesId) {
		this.imagesId = imagesId;
	}

	public Integer getImagesDisplay() {
		return imagesDisplay;
	}

	public void setImagesDisplay(Integer imagesDisplay) {
		this.imagesDisplay = imagesDisplay;
	}

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

	public Integer getImagesSort() {
		return imagesSort;
	}

	public void setImagesSort(Integer imagesSort) {
		this.imagesSort = imagesSort;
	}

	public String getImagesDescirption() {
		return imagesDescirption;
	}

	public void setImagesDescirption(String imagesDescirption) {
		this.imagesDescirption = imagesDescirption;
	}
	
	
}
