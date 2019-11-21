package com.example.commonlibrary.interfaces;

public interface OnRequestCallBackListener<Q> {
    void onSuccess(Q body, String tag);

    void onFailed(String e, String tag);
}
