package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentVerifySafe extends BaseFragment {

    private static FragmentVerifySafe mFragmentVerifySafe;

    public static FragmentVerifySafe newInstance(String param1) {
        mFragmentVerifySafe = new FragmentVerifySafe();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentVerifySafe.setArguments(args);
        return mFragmentVerifySafe;
    }

    public FragmentVerifySafe() {
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_verify_safe;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
