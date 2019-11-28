package com.example.mylibrary.fragment.per_center;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class PerCenterSettingFragment extends BaseFragment implements View.OnClickListener {

    private PerCenterActivity mPerCenterActivity;
    private static PerCenterSettingFragment mPerCenterSettingFragment;
    private TextView mTvAccountAndSafe;

    public PerCenterSettingFragment() {
    }

    public static PerCenterSettingFragment newInstance(String param1) {
        mPerCenterSettingFragment = new PerCenterSettingFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mPerCenterSettingFragment.setArguments(args);
        return mPerCenterSettingFragment;
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_per_center_setting;
    }

    @Override
    public void initView(View view) {
        mPerCenterActivity = (PerCenterActivity) getActivity();
        mTvAccountAndSafe = view.findViewById(R.id.tv_account_and_safe);
    }

    @Override
    public void initData() {
        mTvAccountAndSafe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_account_and_safe){
            mPerCenterActivity.showFragment(2);
        }
    }
}
