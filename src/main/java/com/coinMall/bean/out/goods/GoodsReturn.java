package com.coinMall.bean.out.goods;
/********
 * author:wubingqiao
 * date:2018/10/23 0023 下午 4:55
 * description:深圳
 * version:1.0
 ******/

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date:Administrator
 * Time:下午 4:55
 */
public class GoodsReturn {

    @ApiModelProperty(value="商品ID")
    private Long goodsId;
    @ApiModelProperty(value="商品类型")
    private Integer categoryId;
    @ApiModelProperty(value="商品名字")
    private String goodsName;
    @ApiModelProperty(value="商品简称")
    private String goodsShortName;
    @ApiModelProperty(value="商品图片")
    private String goodsImg;
    @ApiModelProperty(value="商品说明")
    private String goodsDescription;
    @ApiModelProperty(value="商品简要")
    private String goodsShortDescription;
    @ApiModelProperty(value="商品金额")
    private Double goodsAmount;
    @ApiModelProperty(value="兑换所需要的金币")
    private Double goodsGold;
    @ApiModelProperty(value="库存总数量")
    private Integer goodsTotal;
    @ApiModelProperty(value="商品详情")
    private String goodsDetail;
    @ApiModelProperty(value="浏览次数")
    private Integer goodsBrowseTotal;
    @ApiModelProperty(value="兑换次数")
    private Integer goodsExchangeTotal;
    @ApiModelProperty(value="商品排序")
    private String goodsSort;
    @ApiModelProperty(value="上架时间")
    private Date goodsCreateTime;
    @ApiModelProperty(value="最近更新时间")
    private Date goodsUpdateTime;
    @ApiModelProperty(value="商品状态")
    private String goodsStatus;
    @ApiModelProperty(value="是否推荐")
    private String goodsRecommend;
    @ApiModelProperty(value="推荐时间")
    private Date recommendTime;
    @ApiModelProperty(value="推荐广告图")
    private String recommendImage;
    @ApiModelProperty(value="推荐关键字")
    private String goodsKeyWords;


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsShortName() {
        return goodsShortName;
    }

    public void setGoodsShortName(String goodsShortName) {
        this.goodsShortName = goodsShortName == null ? null : goodsShortName.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    public String getGoodsShortDescription() {
        return goodsShortDescription;
    }

    public void setGoodsShortDescription(String goodsShortDescription) {
        this.goodsShortDescription = goodsShortDescription == null ? null : goodsShortDescription.trim();
    }

    public Double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Double getGoodsGold() {
        return goodsGold;
    }

    public void setGoodsGold(Double goodsGold) {
        this.goodsGold = goodsGold;
    }

    public Integer getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(Integer goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public Integer getGoodsBrowseTotal() {
        return goodsBrowseTotal;
    }

    public void setGoodsBrowseTotal(Integer goodsBrowseTotal) {
        this.goodsBrowseTotal = goodsBrowseTotal;
    }

    public Integer getGoodsExchangeTotal() {
        return goodsExchangeTotal;
    }

    public void setGoodsExchangeTotal(Integer goodsExchangeTotal) {
        this.goodsExchangeTotal = goodsExchangeTotal;
    }

    public String getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(String goodsSort) {
        this.goodsSort = goodsSort == null ? null : goodsSort.trim();
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public Date getGoodsUpdateTime() {
        return goodsUpdateTime;
    }

    public void setGoodsUpdateTime(Date goodsUpdateTime) {
        this.goodsUpdateTime = goodsUpdateTime;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus == null ? null : goodsStatus.trim();
    }

    public String getGoodsRecommend() {
        return goodsRecommend;
    }

    public void setGoodsRecommend(String goodsRecommend) {
        this.goodsRecommend = goodsRecommend == null ? null : goodsRecommend.trim();
    }

    public Date getRecommendTime() {
        return recommendTime;
    }

    public void setRecommendTime(Date recommendTime) {
        this.recommendTime = recommendTime;
    }

    public String getRecommendImage() {
        return recommendImage;
    }

    public void setRecommendImage(String recommendImage) {
        this.recommendImage = recommendImage == null ? null : recommendImage.trim();
    }

    public String getGoodsKeyWords() {
        return goodsKeyWords;
    }

    public void setGoodsKeyWords(String goodsKeyWords) {
        this.goodsKeyWords = goodsKeyWords == null ? null : goodsKeyWords.trim();
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }


}
