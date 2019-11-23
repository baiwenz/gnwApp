package com.example.mylibrary.fragment.Login;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.alibaba.android.arouter.launcher.ARouter;
import com.dd.processbutton.iml.ActionProcessButton;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.ARouter.LoginNavigationCallbackImpl;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.ProgressGenerator;
import com.example.mylibrary.R;

public class FragmentLogin extends BaseFragment implements View.OnClickListener, ProgressGenerator.OnCompleteListener {
    private LoginActivity loginActivity;
    private static FragmentLogin mFragmentLogin;
    private TextView mRegister;
    private TextView mForgotPwd;
    private ActionProcessButton btnSignIn;
    final ProgressGenerator progressGenerator = new ProgressGenerator(this);
    public static FragmentLogin newInstance(String param1) {
        mFragmentLogin = new FragmentLogin();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mFragmentLogin.setArguments(args);
        return mFragmentLogin;
    }

    public FragmentLogin() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView(View view) {
        loginActivity=(LoginActivity) getActivity();
        mRegister = view.findViewById(R.id.tv_register);
        mForgotPwd = view.findViewById(R.id.tv_forgot_pwd);
        btnSignIn = (ActionProcessButton) view.findViewById(R.id.btn_login);
    }
    @Override
    public void initData() {
        mRegister.setOnClickListener(this);
        mForgotPwd.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private void setLoginBtnLoginLoading(){
        btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
        progressGenerator.start(btnSignIn);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_register){
            loginActivity.showFragment(1);
        }else if(view.getId() == R.id.tv_forgot_pwd){
            loginActivity.showFragment(4);
        }else if (view.getId()==R.id.btn_login){
            setLoginBtnLoginLoading();
        }
    }

    @Override
    public void onComplete() {
    }
}
