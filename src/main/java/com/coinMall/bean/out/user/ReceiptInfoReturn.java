package com.coinMall.bean.out.user;

import io.swagger.annotations.ApiModelProperty;

/** 
 * @author jiangjiayi
 * @date 2018年10月19日
 */
public class ReceiptInfoReturn {

	@ApiModelProperty(value="ID")
	private Integer receiptId;
	@ApiModelProperty(value="用户ID")
	private Integer uid;
	@ApiModelProperty(value="收货省份")
	private String receiptProvince;
	@ApiModelProperty(value="收货市县")
	private String receiptCity;
	@ApiModelProperty(value="收货区县")
	private String receiptDistrict;
	@ApiModelProperty(value="详情地址")
	private String receiptDetailAddress;
	@ApiModelProperty(value="收货人")
	private String receiptName;
	@ApiModelProperty(value="收货人手机号")
	private String receiptPhone;
	@ApiModelProperty(value="是否默认为收货地址（0-否，1-是）")
	private Integer receiptDefault;
	
	@ApiModelProperty(value="完整收货地址")
	private String receiptFullAddress;

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

	public String getReceiptFullAddress() {
		return receiptFullAddress;
	}

	public void setReceiptFullAddress(String receiptFullAddress) {
		this.receiptFullAddress = receiptFullAddress;
	}
}
