package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentForgotPwd extends BaseFragment {


    private static FragmentForgotPwd mFragmentForgotPwd;

    public static FragmentForgotPwd newInstance(String param1) {
        mFragmentForgotPwd = new FragmentForgotPwd();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentForgotPwd.setArguments(args);
        return mFragmentForgotPwd;
    }

    public FragmentForgotPwd() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_forgot_pwd;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
