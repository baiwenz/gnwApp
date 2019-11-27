package com.example.mylibrary.view.login;

import com.example.commonlibrary.utils.Result;
import com.example.commonlibrary.view.BaseView;

public interface RegisterView<T> extends BaseView {
    /**
     * 发送验证码
     */
    void postCode();

    /**
     * 发送验证码回调
     * @param result
     */
    void rePostCode(Result result);
}
