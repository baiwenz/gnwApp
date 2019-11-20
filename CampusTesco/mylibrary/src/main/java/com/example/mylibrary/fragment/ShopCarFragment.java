package com.example.mylibrary.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class ShopCarFragment extends BaseFragment {
    public static ShopCarFragment sShopCarFragment;
    public static ShopCarFragment newInstance(String param1){
        sShopCarFragment=new ShopCarFragment();
        Bundle ages=new Bundle();
        ages.putString("asd",param1);
        sShopCarFragment.setArguments(ages);
        return  sShopCarFragment;
    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.shopcar_fragment;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
