package com.example.commonlibrary.interfaces;

import com.example.commonlibrary.bean.ApiResult;

public interface OnRequestCallBackListener<Q> {
    void onSuccess(Q body, String tag);

    void onFailed(String e, String tag);
}
