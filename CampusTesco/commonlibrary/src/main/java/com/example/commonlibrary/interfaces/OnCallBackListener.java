package com.example.commonlibrary.interfaces;

public interface OnCallBackListener<T> {
    //因为成功的回调中由于每个请求的数据都是不同的所以用范型来定义
    void onSuccess(T t);
    //而失败只会有一种情况 所以这里直接用字符串的方式来接收
    void onFailed(String e);

}
