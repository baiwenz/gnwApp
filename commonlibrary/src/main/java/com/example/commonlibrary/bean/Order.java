package com.example.commonlibrary.bean;

import com.example.commonlibrary.base.BaseEntity;

import java.util.List;

public class Order extends BaseEntity{
    private String id;
    private String shop_img_url;
    private String shop_name;
    private String shop_id;
    private double All_price;
    private List<Goods> goodsList;
    private int state;
    private String remark;
    public Order() {
    }
    public Order(String id, String shop_img_url, String shop_name, String shop_id, double all_price, List<Goods> goodsList, int state, String remark) {
        this.id = id;
        this.shop_img_url = shop_img_url;
        this.shop_name = shop_name;
        this.shop_id = shop_id;
        All_price = all_price;
        this.goodsList = goodsList;
        this.state = state;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_img_url() {
        return shop_img_url;
    }

    public void setShop_img_url(String shop_img_url) {
        this.shop_img_url = shop_img_url;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public double getAll_price() {
        return All_price;
    }

    public void setAll_price(double all_price) {
        All_price = all_price;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
