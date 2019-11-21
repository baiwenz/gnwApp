package com.example.commonlibrary.bean;

import java.math.BigDecimal;

public class Goods {
    private String id;

    private String belongShopID;

    private String goodName;

    private String goodSrc;

    private String goodDesc;

    private Integer goodNum;

    private BigDecimal gooPrice;

    private BigDecimal goodNowPrice;

    private String goodSale;

    private String goodTitle;

    private String goodType;

    private String state;

    private String remark;

    private String spare1;

    private String spare2;

    private String spare3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBelongShopID() {
        return belongShopID;
    }

    public void setBelongShopID(String belongShopID) {
        this.belongShopID = belongShopID == null ? null : belongShopID.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodSrc() {
        return goodSrc;
    }

    public void setGoodSrc(String goodSrc) {
        this.goodSrc = goodSrc == null ? null : goodSrc.trim();
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc == null ? null : goodDesc.trim();
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public BigDecimal getGooPrice() {
        return gooPrice;
    }

    public void setGooPrice(BigDecimal gooPrice) {
        this.gooPrice = gooPrice;
    }

    public BigDecimal getGoodNowPrice() {
        return goodNowPrice;
    }

    public void setGoodNowPrice(BigDecimal goodNowPrice) {
        this.goodNowPrice = goodNowPrice;
    }

    public String getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(String goodSale) {
        this.goodSale = goodSale == null ? null : goodSale.trim();
    }

    public String getGoodTitle() {
        return goodTitle;
    }

    public void setGoodTitle(String goodTitle) {
        this.goodTitle = goodTitle == null ? null : goodTitle.trim();
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType == null ? null : goodType.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1 == null ? null : spare1.trim();
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2 == null ? null : spare2.trim();
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }
}