package com.example.mylibrary.fragment.Login;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.commonlibrary.base.Constants.loginCurrentFragment;

public class LoginActivity extends BaseActivity{
    private FragmentManager fragmentManager;
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
    private List<Integer> reBackFrement=new ArrayList<Integer>();
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
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        //先隐藏其他的
        for (int i = 0; i < fragments.size(); i++) {
            fragment = fragments.get(i);
            if (i == position) {
                transaction.replace(R.id.fl_login,fragment);
                if(i!=0) transaction.addToBackStack(null);
            }
        }
        transaction.commit();

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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
