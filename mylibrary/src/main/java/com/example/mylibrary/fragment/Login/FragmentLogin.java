package com.example.mylibrary.fragment.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.ARouter.LoginNavigationCallbackImpl;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class FragmentLogin extends BaseFragment implements View.OnClickListener {

    private static FragmentLogin mFragmentLogin;
    private TextView mTv;

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

        mTv = view.findViewById(R.id.tv_register);
        mTv.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.tv_register){
            ARouter.getInstance()
                    .build(Constance.SEARCH_ACTIVITY)
                    .navigation(getActivity(),new LoginNavigationCallbackImpl());
        }

    }
}
