package com.coinMall.bean.in.user;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月19日
 */
public class ReceiptInfoModel {

	@ApiModelProperty(value="ID,修改操作时必传",required=false)
	private Integer receiptId;
	@ApiModelProperty(value="用户ID",required=true)
	private Integer uid;
	@ApiModelProperty(value="收货国家",required=false,hidden=true)
	private String receiptCountry;
	@ApiModelProperty(value="收货省份",required=true)
	private String receiptProvince;
	@ApiModelProperty(value="收货市县",required=true)
	private String receiptCity;
	@ApiModelProperty(value="收货区县",required=true)
	private String receiptDistrict;
	@ApiModelProperty(value="详情地址",required=true)
	private String receiptDetailAddress;
	@ApiModelProperty(value="邮政编码",required=false,hidden=true)
	private String receiptZcode;
	@ApiModelProperty(value="收货人",required=true)
	private String receiptName;
	@ApiModelProperty(value="收货人手机号",required=true)
	private String receiptPhone;
	@ApiModelProperty(value="是否默认为收货地址（0-否，1-是）",required=true,allowableValues="0,1")
	private Integer receiptDefault;
	
	public Integer getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getReceiptCountry() {
		return receiptCountry;
	}
	public void setReceiptCountry(String receiptCountry) {
		this.receiptCountry = receiptCountry;
	}
	public String getReceiptProvince() {
		return receiptProvince;
	}
	public void setReceiptProvince(String receiptProvince) {
		this.receiptProvince = receiptProvince;
	}
	public String getReceiptCity() {
		return receiptCity;
	}
	public void setReceiptCity(String receiptCity) {
		this.receiptCity = receiptCity;
	}
	public String getReceiptDistrict() {
		return receiptDistrict;
	}
	public void setReceiptDistrict(String receiptDistrict) {
		this.receiptDistrict = receiptDistrict;
	}
	public String getReceiptDetailAddress() {
		return receiptDetailAddress;
	}
	public void setReceiptDetailAddress(String receiptDetailAddress) {
		this.receiptDetailAddress = receiptDetailAddress;
	}
	public String getReceiptZcode() {
		return receiptZcode;
	}
	public void setReceiptZcode(String receiptZcode) {
		this.receiptZcode = receiptZcode;
	}
	public String getReceiptName() {
		return receiptName;
	}
	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}
	public String getReceiptPhone() {
		return receiptPhone;
	}
	public void setReceiptPhone(String receiptPhone) {
		this.receiptPhone = receiptPhone;
	}
	public Integer getReceiptDefault() {
		return receiptDefault;
	}
	public void setReceiptDefault(Integer receiptDefault) {
		this.receiptDefault = receiptDefault;
	} 
	
}
