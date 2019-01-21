package com.coinMall.bean.out.goods;

import io.swagger.annotations.ApiModelProperty;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月25日 下午3:28:27 
* 类说明 
*/
public class CategoryReturn {
   @ApiModelProperty(value="商品的分类Id")
   private Integer categoryId;
   @ApiModelProperty(value="商品的分类名字")
   private String categoryName;
   @ApiModelProperty(value="商品的分类标题")
   private String categoryTitle;
   
   @ApiModelProperty(value="商品的分类排序")
   private Integer categorySort;
   @ApiModelProperty(value="")
   private Short categoryDisplay;
   @ApiModelProperty(value="商品分类的    父类ID")
   private Integer categoryParentId;
   @ApiModelProperty(value = "商品分类的层级")
   private Integer categoryLevel;
	   
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public Integer getCategorySort() {
		return categorySort;
	}
	public void setCategorySort(Integer categorySort) {
		this.categorySort = categorySort;
	}
	public Short getCategoryDisplay() {
		return categoryDisplay;
	}
	public void setCategoryDisplay(Short categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}
	public Integer getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(Integer categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public Integer getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
   
   
}




















