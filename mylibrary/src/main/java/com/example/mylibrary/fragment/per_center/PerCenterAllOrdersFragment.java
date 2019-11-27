package com.example.mylibrary.fragment.per_center;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;
import com.example.mylibrary.adapter.PerCenterForOrderAdapter;

public class PerCenterAllOrdersFragment extends BaseFragment {

   private PerCenterActivity mPerCenterActivity;

   private static PerCenterAllOrdersFragment mPerCenterAllOrdersFragment;
    private RecyclerView mRvOrders;
    private PerCenterForOrderAdapter mAdapter;

    public PerCenterAllOrdersFragment(){

    }

    public static PerCenterAllOrdersFragment newInstance(String param1) {
        mPerCenterAllOrdersFragment = new PerCenterAllOrdersFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        mPerCenterAllOrdersFragment.setArguments(args);
        return mPerCenterAllOrdersFragment;
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_per_center_all_orders;
    }

    @Override
    public void initView(View view) {
        mPerCenterActivity = new PerCenterActivity();
        mRvOrders = view.findViewById(R.id.rv_orders);
        mAdapter = new PerCenterForOrderAdapter();
    }

    @Override
    public void initData() {

        mRvOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvOrders.setAdapter(mAdapter);

    }


}
