package com.coinMall.bean.out.goods;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/** 
 * @author wubingqiao
 * @date 2018年10月17日
 */
public class GoodsPageReturn {

	@ApiModelProperty(value="商品信息数据体")
	private List<GoodsReturn> goodsModelList;
	
	@ApiModelProperty(value="当前页数")
	private Integer pageIndex;
	
	@ApiModelProperty(value="分页大小")
	private Integer pageSize;
	
	@ApiModelProperty(value="数据总数")
	private Integer totalCount;
	
	@ApiModelProperty(value="总页数")
	private Integer totalPages;

	public List<GoodsReturn> getGoodsModelList() {
		return goodsModelList;
	}

	public void setGoodsModelList(List<GoodsReturn> goodsModelList) {
		this.goodsModelList = goodsModelList;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
}
