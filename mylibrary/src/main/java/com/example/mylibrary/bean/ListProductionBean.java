package com.example.mylibrary.bean;

import android.widget.SearchView;

public class ListProductionBean {
    private int pic;
    private String name;
    private double price_now;
    private double price_post;

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice_now() {
        return price_now;
    }

    public void setPrice_now(double price_now) {
        this.price_now = price_now;
    }

    public double getPrice_post() {
        return price_post;
    }

    public void setPrice_post(double price_post) {
        this.price_post = price_post;
    }
}
