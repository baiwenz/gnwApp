package com.example.mylibrary.fragment.per_center;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class PerCenterSettingSafeFragment extends BaseFragment {


    private PerCenterActivity mPerCenterActivity;
    private static PerCenterSettingSafeFragment mPerCenterSettingSafeFragment;

    public PerCenterSettingSafeFragment() {
    }

    public static PerCenterSettingSafeFragment newInstance(String param1) {
        mPerCenterSettingSafeFragment = new PerCenterSettingSafeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mPerCenterSettingSafeFragment.setArguments(args);
        return mPerCenterSettingSafeFragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_per_center_setting_safe;
    }

    @Override
    public void initView(View view) {
        mPerCenterActivity = (PerCenterActivity) getActivity();
    }

    @Override
    public void initData() {

    }
}
