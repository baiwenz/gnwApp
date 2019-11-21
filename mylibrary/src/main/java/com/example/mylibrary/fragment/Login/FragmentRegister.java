package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentRegister extends BaseFragment {


    private static FragmentRegister mFragmentRegister;

    public static FragmentRegister newInstance(String param1) {
        mFragmentRegister = new FragmentRegister();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentRegister.setArguments(args);
        return mFragmentRegister;
    }

    public FragmentRegister() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_register;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
