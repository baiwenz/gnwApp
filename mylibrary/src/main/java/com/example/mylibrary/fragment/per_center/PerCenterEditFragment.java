package com.example.mylibrary.fragment.per_center;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class PerCenterEditFragment extends BaseFragment {

    private PerCenterActivity mPerCenterActivity;
    private static PerCenterEditFragment mPerCenterEditFragment;

    public PerCenterEditFragment() {
    }

    public static PerCenterEditFragment newInstance(String param1) {
        mPerCenterEditFragment = new PerCenterEditFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mPerCenterEditFragment.setArguments(args);
        return mPerCenterEditFragment;
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_per_center_edit;
    }

    @Override
    public void initView(View view) {
        mPerCenterActivity = new PerCenterActivity();
    }

    @Override
    public void initData() {

    }
}
