package com.example.mylibrary.model.login.impl;

import com.example.commonlibrary.base.UrlConfig;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.interfaces.OnRequestCallBackListener;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.model.login.RegisterModel;

public class RegisterModelImpl implements RegisterModel {
    @Override
    public void postCode(String phoneNumber, final OnCallBackListener onCallBackListener) {
        RetrofitUtils.postMsg(UrlConfig.POST_CODE,phoneNumber,new OnRequestCallBackListener<Result>(){

            @Override
            public void onSuccess(Result body, String tag) {
                onCallBackListener.onSuccess(body);
            }

            @Override
            public void onFailed(String e, String tag) {
                onCallBackListener.onFailed(e);
            }
        });
    }

    @Override
    public void loadDate(OnCallBackListener callBackListener) {

    }
}
