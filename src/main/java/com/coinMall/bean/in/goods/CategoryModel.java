package com.coinMall.bean.in.goods;

import io.swagger.annotations.ApiModelProperty;

/** 
* @author 作者 wubingqiao: 
* @version 创建时间：2018年10月25日 下午2:59:53 
* 类说明 
*/
public class CategoryModel {
   @ApiModelProperty(value = "分类的ID，如果是新增，则不需要携带分类ID，如果不是修改，则必须携带ID" ,required = false)
   private Integer categoryId;
   @ApiModelProperty(value = "分类的名字" ,required = true)
   private String categoryName;
   @ApiModelProperty(value = "分类标题" ,required = true)
   private String categoryTitle;
   @ApiModelProperty(value = "分类排序",required = false)
   private Integer categorySort;
   @ApiModelProperty(value = "是否显示" ,required=false ,allowableValues = "1")
   private Short categoryDisplay;
   @ApiModelProperty(value = "父类Id" ,required = true)
   private Integer categoryParentId;
   @ApiModelProperty(value = "层级",required = true)
   private Integer categoryLevel;
   
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
