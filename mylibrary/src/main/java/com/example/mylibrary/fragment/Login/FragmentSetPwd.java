package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentSetPwd extends BaseFragment implements View.OnClickListener{
    private LoginActivity loginActivity;
    private Button mSetPwd;
    private static FragmentSetPwd mFragmentSetPwd;

    public static FragmentSetPwd newInstance(String param1) {
        mFragmentSetPwd = new FragmentSetPwd();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentSetPwd.setArguments(args);
        return mFragmentSetPwd;
    }

    public FragmentSetPwd() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_set_pwd;
    }

    @Override
    public void initView(View view) {
        loginActivity=(LoginActivity) getActivity();
        mSetPwd=view.findViewById(R.id.btn_submit_confirm);
    }

    @Override
    public void initData() {
        mSetPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_submit_confirm){

        }
    }
}
