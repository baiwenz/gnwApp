package com.example.mylibrary.fragment.Login;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.ARouter.LoginNavigationCallbackImpl;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

import java.util.ArrayList;
import static com.example.commonlibrary.base.Constants.loginCurrentFragment;

public class LoginActivity extends BaseActivity{
    private ArrayList<Fragment> fragments;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private FragmentLogin mFragmentLogin;
    private FragmentRegister mFragmentRegister;
    private FragmentInputCode mFragmentInputCode; //输入验证码
    private FragmentSetPwd mFragmentSetPwd;
    private FragmentForgotPwd mFragmentForgotPwd;
    private FragmentVerifySafe mFragmentVerifySafe;
    private FragmentFindLoginPwd mFragmentFindLoginPwd; //找回登陆密码

    private void prepareFragments() {
        fragments = new ArrayList<>();

        if (mFragmentLogin == null) {
            mFragmentLogin = FragmentLogin.newInstance("登录");
        }
        fragments.add(mFragmentLogin);

        if (mFragmentRegister == null) {
            mFragmentRegister = FragmentRegister.newInstance("注册");
        }
        fragments.add(mFragmentRegister);

        if (mFragmentInputCode ==null){
            mFragmentInputCode=FragmentInputCode.newInstance("输入验证码");
        }
        fragments.add(mFragmentInputCode);

        if (mFragmentSetPwd ==null){
            mFragmentSetPwd=FragmentSetPwd.newInstance("设置密码");
        }
        fragments.add(mFragmentSetPwd);

        if (mFragmentForgotPwd ==null){
            mFragmentForgotPwd=FragmentForgotPwd.newInstance("忘记密码");
        }
        fragments.add(mFragmentForgotPwd);

        if (mFragmentVerifySafe ==null){
            mFragmentVerifySafe=FragmentVerifySafe.newInstance("安全验证");
        }
        fragments.add(mFragmentVerifySafe);

        if (mFragmentFindLoginPwd ==null){
            mFragmentFindLoginPwd=FragmentFindLoginPwd.newInstance("找回密码");
        }
        fragments.add(mFragmentFindLoginPwd);



    }
    public void showFragment(int position) {
        loginCurrentFragment = position;
        FragmentManager fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        //先隐藏其他的
        for (int i = 0; i < fragments.size(); i++) {
            fragment = fragments.get(i);
            if (i == position) {
                if (fragment.isAdded()) {
                    transaction.show(fragment);
                } else {
                    //add
                    transaction.add(R.id.fl_login, fragment);
                }
            } else {
                if (fragment.isAdded()) {
                    transaction.hide(fragment);
                }
            }
        }
        //commit
        transaction.commitAllowingStateLoss();

    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        prepareFragments();
    }

    @Override
    public void initData() {
        showFragment(0);
    }
}
