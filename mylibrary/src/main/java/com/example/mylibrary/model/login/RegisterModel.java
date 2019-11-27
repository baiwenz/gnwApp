package com.example.mylibrary.model.login;

import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.model.BaseModel;

public interface RegisterModel extends BaseModel {
    /**
     * 发送验证码
     * @param phoneNumber
     * @param onCallBackListener
     */
    void postCode(String phoneNumber, OnCallBackListener onCallBackListener);
}
