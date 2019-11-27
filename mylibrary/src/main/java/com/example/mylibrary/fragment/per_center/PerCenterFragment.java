package com.example.mylibrary.fragment.per_center;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;


public class PerCenterFragment extends BaseFragment implements View.OnClickListener {

    private PerCenterActivity mPerCenterActivity;
    private static PerCenterFragment mPerCenterFragment;
    private ImageView mIvSetting;
    private Button mBtnEdt;
    private TextView mTvFIndAllOrders;

    public PerCenterFragment() {
    }

    public static PerCenterFragment newInstance(String param1) {
        mPerCenterFragment = new PerCenterFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mPerCenterFragment.setArguments(args);
        return mPerCenterFragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_per_center;
    }

    @Override
    public void initView(View view) {
        mPerCenterActivity = (PerCenterActivity) getActivity();
        mIvSetting = view.findViewById(R.id.iv_setting);
        mBtnEdt = view.findViewById(R.id.btn_edt);
        mTvFIndAllOrders = view.findViewById(R.id.tv_find_all_orders);
    }

    @Override
    public void initData() {
        mIvSetting.setOnClickListener(this);
        mBtnEdt.setOnClickListener(this);
        mTvFIndAllOrders.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_setting) {
            mPerCenterActivity.showFragment(1);
        }

        if (view.getId() == R.id.btn_edt){
            mPerCenterActivity.showFragment(3);
        }

        if (view.getId() == R.id.tv_find_all_orders){
            mPerCenterActivity.showFragment(4);
        }
    }
}

