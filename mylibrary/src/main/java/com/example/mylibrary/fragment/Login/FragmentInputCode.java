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
import com.example.mylibrary.fragment.MessageFragment;

public class FragmentInputCode extends BaseFragment implements View.OnClickListener{
    private LoginActivity loginActivity;
    private EditText mCode;
    private Button mCheckCode;
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
        loginActivity=(LoginActivity) getActivity();
        mCheckCode=view.findViewById(R.id.btn_get_code);
        mCode=view.findViewById(R.id.edt_input_code);
    }

    @Override
    public void initData() {
        mCheckCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_get_code){
            loginActivity.showFragment(3);
        }
    }
}
