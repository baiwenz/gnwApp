package com.example.mylibrary.model.Impl;

import android.util.Log;

import com.example.commonlibrary.bean.Repo;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.interfaces.OnRequestCallBackListener;
import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.mylibrary.bean.HomeBean;
import com.example.mylibrary.model.HomeModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeModelImpl implements HomeModel {
    @Override
    public void loadDate(final OnCallBackListener callBackListener) {

        RetrofitUtils.getRxRepos("octocat", new OnRequestCallBackListener<Object>() {

            @Override
            public void onSuccess(Object body, String tag) {
                System.out.println(body);
                callBackListener.onSuccess(null);
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
