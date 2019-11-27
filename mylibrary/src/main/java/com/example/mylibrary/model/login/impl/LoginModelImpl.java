package com.example.mylibrary.model.login.impl;

import com.example.commonlibrary.base.UrlConfig;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.interfaces.OnRequestCallBackListener;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.model.login.LoginModel;

public class LoginModelImpl implements LoginModel {

    @Override
    public void loadDate(OnCallBackListener callBackListener) {

    }

    @Override
    public void login(String username, String password, final OnCallBackListener callBackListener) {
        RetrofitUtils.login(UrlConfig.LOGIN, username, password, new OnRequestCallBackListener<Result>() {
            @Override
            public void onSuccess(Result body, String tag) {
                callBackListener.onSuccess(body);
            }

            @Override
            public void onFailed(String e, String tag) {
                callBackListener.onFailed(e);
            }
        });
    }
}
