package com.example.mylibrary.model.Impl;

import android.widget.Toast;

import com.example.commonlibrary.base.UrlConfig;
import com.example.commonlibrary.bean.ApiResult;
import com.example.commonlibrary.bean.Goods;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.interfaces.OnRequestCallBackListener;
import com.example.commonlibrary.interfaces.OnCallBackListener;
import com.example.mylibrary.bean.HomeBean;
import com.example.mylibrary.model.HomeModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeModelImpl implements HomeModel {
    @Override
    public void loadDate(final OnCallBackListener callBackListener) {

        RetrofitUtils.get(UrlConfig.NEWS_URL, new OnRequestCallBackListener<String>() {

            @Override
            public void onSuccess(String body, String tag) {
                Type type = new TypeToken<ArrayList<Goods>>() {}.getType();
                Gson gson = new Gson();
                List<Goods> goodsList = gson.fromJson(body,type);
                ApiResult apiResult = new ApiResult();
                apiResult.setGoods(goodsList);
                callBackListener.onSuccess(apiResult);
            }
            @Override
            public void onFailed(String e, String tag) {

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
