package com.example.mylibrary.view;


import com.example.commonlibrary.bean.Repo;
import com.example.commonlibrary.view.BaseView;

/**
 * Created by yc on 2018/7/25.
 */

public interface IHomeView<T> extends BaseView<T> {
    //接收显示recyview中的数据
    void showhome(Repo apiResult);
}
