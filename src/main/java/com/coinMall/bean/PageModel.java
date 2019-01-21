package com.coinMall.bean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class PageModel<T> {
	@ApiModelProperty(value="当前页")
	protected int pageIndex;
	@ApiModelProperty(value="页大小")
	protected int pageSize;
	@ApiModelProperty(value="总记录数")
	protected Integer totalCount;
	@ApiModelProperty(value="数据体")
	protected List<T> pageDatas;
	
	public PageModel() {
		super();
	}
	public PageModel(int pageIndex, int pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getPageDatas() {
		return pageDatas;
	}
	public void setPageDatas(List<T> pageDatas) {
		this.pageDatas = pageDatas;
	}
	
}