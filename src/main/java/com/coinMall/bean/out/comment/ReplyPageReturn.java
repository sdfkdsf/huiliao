package com.coinMall.bean.out.comment;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月17日
 */
public class ReplyPageReturn {

	@ApiModelProperty(value="数据体")
	private List<ReplyReturn> replys;
	@ApiModelProperty(value="总条数")
	private Integer totalCount;
	
	public List<ReplyReturn> getReplys() {
		return replys;
	}
	public void setReplys(List<ReplyReturn> replys) {
		this.replys = replys;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
