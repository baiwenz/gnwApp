package com.example.mylibrary.fragment.per_center;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

@Route(path = "/my/MyFragment")
public class PerCenterFragment extends BaseFragment implements View.OnClickListener {

    private PerCenterActivity mPerCenterActivity;
    private static PerCenterFragment mPerCenterFragment;
    private ImageView mIvSetting;
    private Button mBtnEdt;
    private TextView mTvFindAllOrders;
    private RelativeLayout mPendPayment,mPendShip,mShip,mPendEvaluation,mAfterSaleService;

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

        //设置
        mIvSetting = view.findViewById(R.id.iv_setting);
        //编辑
        mBtnEdt = view.findViewById(R.id.btn_edt);
        //查看全部订单
        mTvFindAllOrders = view.findViewById(R.id.tv_find_all_orders);
        //待付款、待发货、已发货、待评价、售后服务
        mPendPayment = view.findViewById(R.id.rl_pend_payment);
        mPendShip = view.findViewById(R.id.rl_pend_ship);
        mShip = view.findViewById(R.id.rl_ship);
        mPendEvaluation = view.findViewById(R.id.rl_pend_evaluation);
        mAfterSaleService = view.findViewById(R.id.rl_after_sale_service);

    }

    @Override
    public void initData() {
        //设置
        mIvSetting.setOnClickListener(this);
        //编辑
        mBtnEdt.setOnClickListener(this);
        //查看全部订单
        mTvFindAllOrders.setOnClickListener(this);
        // 待付款、待发货、已发货、待评价、售后服务
        mPendPayment.setOnClickListener(this);
        mPendShip.setOnClickListener(this);
        mShip.setOnClickListener(this);
        mPendEvaluation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //设置
        if (view.getId() == R.id.iv_setting) {
            mPerCenterActivity.showFragment(1);
        }
        //编辑
        if (view.getId() == R.id.btn_edt){
            mPerCenterActivity.showFragment(3);
        }
        //查看全部订单
        if (view.getId() == R.id.tv_find_all_orders){
            Intent intent = new Intent(getActivity(),TabLayoutForOrdersActivity.class);
            startActivity(intent);
        }
        //待付款、待发货、已发货、待评价、售后服务
        if (view.getId() == R.id.rl_pend_payment){
            Intent intent = new Intent(getActivity(),TabLayoutForOrdersActivity.class);
            intent.putExtra("selectIndex",1);
            startActivity(intent);
        }
        if (view.getId() == R.id.rl_pend_ship){
            Intent intent = new Intent(getActivity(),TabLayoutForOrdersActivity.class);
            intent.putExtra("selectIndex",2);
            startActivity(intent);
        }
        if (view.getId() == R.id.rl_ship){
            Intent intent = new Intent(getActivity(),TabLayoutForOrdersActivity.class);
            intent.putExtra("selectIndex",3);
            startActivity(intent);
        }
        if (view.getId() == R.id.rl_pend_evaluation){
            Intent intent = new Intent(getActivity(),TabLayoutForOrdersActivity.class);
            intent.putExtra("selectIndex",4);
            startActivity(intent);
        }

    }


}

