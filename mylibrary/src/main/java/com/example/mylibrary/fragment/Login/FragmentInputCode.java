package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;
import com.example.mylibrary.fragment.MessageFragment;

public class FragmentInputCode extends BaseFragment {

    private static FragmentInputCode mFragmentInputCode;

    public static FragmentInputCode newInstance(String param){
        mFragmentInputCode = new FragmentInputCode();
        Bundle args = new Bundle();
        args.putString("agrs1", param);
        mFragmentInputCode.setArguments(args);
        return mFragmentInputCode;
    }

    public FragmentInputCode() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_input_code;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
