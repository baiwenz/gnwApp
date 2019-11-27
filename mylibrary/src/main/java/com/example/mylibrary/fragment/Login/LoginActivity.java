package com.example.mylibrary.fragment.Login;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;


public class LoginActivity extends BaseActivity{
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FragmentLogin mFragmentLogin;
    public void showFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_login,fragment);
        if(fragment!=mFragmentLogin) transaction.addToBackStack(null);
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
        mFragmentLogin = FragmentLogin.newInstance("登录");
    }

    @Override
    public void initData() {
        showFragment(mFragmentLogin);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
