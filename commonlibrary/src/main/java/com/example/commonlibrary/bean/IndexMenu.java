package com.example.commonlibrary.bean;

import com.example.commonlibrary.base.BaseEntity;

public class IndexMenu extends BaseEntity {
    private String id;
    private String imgURL;
    private String title;
    private String Url;

    public IndexMenu() {
    }
    public IndexMenu(String id, String imgURL, String title, String url) {
        this.id = id;
        this.imgURL = imgURL;
        this.title = title;
        Url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
