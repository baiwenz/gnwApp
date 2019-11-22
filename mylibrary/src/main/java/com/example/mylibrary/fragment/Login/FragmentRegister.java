package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;
@Route(path = Constance.REGISTER_FRAGMENT)
public class FragmentRegister extends BaseFragment implements View.OnClickListener{
    private LoginActivity loginActivity;
    private EditText mPhone;
    private Button mGetCode;
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

    /**
     * 初始化视图
     * @param view
     */
    @Override
    public void initView(View view) {
        loginActivity=(LoginActivity) getActivity();
        mGetCode=view.findViewById(R.id.btn_get_code);
        mPhone=view.findViewById(R.id.edt_input_phone);
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        mGetCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_get_code){
            loginActivity.showFragment(2);
        }
    }
}
