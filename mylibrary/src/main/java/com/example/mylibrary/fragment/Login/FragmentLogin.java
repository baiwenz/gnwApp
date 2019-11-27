package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.dd.processbutton.iml.ActionProcessButton;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.base.Constants;
import com.example.commonlibrary.utils.ProgressGenerator;
import com.example.commonlibrary.utils.Result;
import com.example.mylibrary.R;
import com.example.mylibrary.presenter.login.LoginPresenter;
import com.example.mylibrary.view.login.LoginView;

public class FragmentLogin
        extends BaseFragment<LoginView, LoginPresenter<LoginView>>
        implements LoginView, View.OnClickListener {
    private LoginActivity loginActivity;
    private static FragmentLogin mFragmentLogin;
    private TextView mRegister;
    private TextView mForgotPwd;
    private ActionProcessButton btnSignIn;
    private EditText etUsername,etPassword;
    private FragmentRegister mFragmentRegister;
    private FragmentForgotPwd mFragmentForgotPwd;
    private ProgressGenerator progressGenerator = new ProgressGenerator();
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
    protected LoginPresenter<LoginView> createPresenter() {
        return new LoginPresenter();
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
        etPassword = view.findViewById(R.id.et_password);
        etUsername = view.findViewById(R.id.et_phone);

    }
    @Override
    public void initData() {
        mRegister.setOnClickListener(this);
        mForgotPwd.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    /**
     * 登录动画加载
     */
    private void setLoginBtnLoginLoading(){
        etUsername.setEnabled(false);
        etPassword.setEnabled(false);
        btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
        progressGenerator.setmProgress(Constants.STATR);
        progressGenerator.start(btnSignIn);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_register){
            mFragmentRegister = FragmentRegister.newInstance("注册");
            loginActivity.showFragment(mFragmentRegister);
        }else if(view.getId() == R.id.tv_forgot_pwd){
            mFragmentForgotPwd = FragmentForgotPwd.newInstance("忘记密码");
            loginActivity.showFragment(mFragmentForgotPwd);
        }else if (view.getId()==R.id.btn_login){
            login();
        }
    }
    @Override
    public void login() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        basePresenter.Login(username,password);
    }

    @Override
    public void reBackLogin(Result result) {
        if(result.getFalg()){
            progressGenerator.setmProgress(Constants.SUCCESS);
        }else {
            progressGenerator.setmProgress(Constants.ERROR);
        }
        etUsername.setEnabled(true);
        etPassword.setEnabled(true);
        Toast.makeText(getActivity(),result.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        setLoginBtnLoginLoading();
    }

    @Override
    public void hideLoading(boolean b) {

    }

    @Override
    public void onError(Object result) {
        progressGenerator.setmProgress(Constants.ERROR);
        etUsername.setEnabled(true);
        etPassword.setEnabled(true);
        Toast.makeText(getActivity(),"连接超时",Toast.LENGTH_LONG).show();
    }
}
