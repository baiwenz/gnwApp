package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentFindLoginPwd extends BaseFragment {
    private static FragmentFindLoginPwd mFragmentFindLoginPwd;

    public static FragmentFindLoginPwd newInstance(String param1) {
        mFragmentFindLoginPwd = new FragmentFindLoginPwd();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentFindLoginPwd.setArguments(args);
        return mFragmentFindLoginPwd;
    }

    public FragmentFindLoginPwd() {
    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_find_login_pwd;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }


}
