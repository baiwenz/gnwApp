package com.example.mylibrary.model;

import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.model.BaseModel;
import com.example.commonlibrary.utils.Result;

public interface LoginModel extends BaseModel {
    /**
     * 登录验证回调接口
     * @param username
     * @param password
     * @param callBackListener
     */
    void login(String username,String password,OnCallBackListener callBackListener);
}
