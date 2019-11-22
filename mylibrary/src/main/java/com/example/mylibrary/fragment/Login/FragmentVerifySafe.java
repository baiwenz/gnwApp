package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentVerifySafe extends BaseFragment implements View.OnClickListener{
    private LoginActivity loginActivity;
    private EditText mPhone;
    private EditText mCode;
    private Button mGetCode;
    private Button mCheckCode;
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
        loginActivity=(LoginActivity) getActivity();
        mGetCode=view.findViewById(R.id.btn_get_code);
        mCheckCode=view.findViewById(R.id.btn_check_code);
    }

    @Override
    public void initData() {
        mCheckCode.setOnClickListener(this);
        mGetCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_get_code){
            //发送验证码
        }else if(v.getId() ==R.id.btn_check_code){
            loginActivity.showFragment(6);
        }
    }
}
