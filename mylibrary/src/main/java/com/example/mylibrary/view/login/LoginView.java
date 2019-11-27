package com.example.mylibrary.view.login;

import com.example.commonlibrary.utils.Result;
import com.example.commonlibrary.view.BaseView;

public interface LoginView<T> extends BaseView {
    void login();
    /**
     * 登录结果回调
     * @param result
     */
    void reBackLogin(Result result);
}
