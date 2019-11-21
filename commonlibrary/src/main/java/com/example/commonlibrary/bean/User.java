package com.example.commonlibrary.bean;

public class User {
    private String id;

    private String userName;

    private String password;

    private String sex;

    private String tel;

    private String userFaceSrc;

    private String shopState;

    private String salt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getUserFaceSrc() {
        return userFaceSrc;
    }

    public void setUserFaceSrc(String userFaceSrc) {
        this.userFaceSrc = userFaceSrc == null ? null : userFaceSrc.trim();
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState == null ? null : shopState.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}