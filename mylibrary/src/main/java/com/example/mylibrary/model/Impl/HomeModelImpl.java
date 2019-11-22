package com.example.mylibrary.model.Impl;

import android.util.Log;

import com.example.commonlibrary.base.UrlConfig;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.interfaces.OnRequestCallBackListener;
import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.bean.HomeBean;
import com.example.mylibrary.model.HomeModel;
import java.util.ArrayList;
import java.util.List;

public class HomeModelImpl implements HomeModel {
    @Override
    public void loadDate(final OnCallBackListener callBackListener) {

        RetrofitUtils.get(UrlConfig.GET_MSG, new OnRequestCallBackListener<Result>() {

            @Override
            public void onSuccess(Result result, String tag) {
                System.out.println(result.toString());
                callBackListener.onSuccess(result);
            }
            @Override
            public void onFailed(String e, String tag) {

                Log.e("", e);

            }
        });
    }

    public void loadDate1(OnCallBackListener callBackListener) {
        List<HomeBean> homeBeanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            homeBeanList.add(new HomeBean("名字 ：" + i));
        }
        //通过回调将数据返回给 model层
        callBackListener.onSuccess(homeBeanList);
    }
}
