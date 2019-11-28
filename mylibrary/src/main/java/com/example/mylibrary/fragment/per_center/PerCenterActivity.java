package com.example.mylibrary.fragment.per_center;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.commonlibrary.base.Constants.loginCurrentFragment;

public class PerCenterActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private FragmentTransaction transaction;
    private Fragment fragment;

    private PerCenterFragment mPerCenterFragment;
    private PerCenterSettingFragment mPerCenterSettingFragment;
    private PerCenterSettingSafeFragment mPerCenterSettingSafeFragment;
    private PerCenterEditFragment mPerCenterEditFragment;

    private List<Integer> reBackFragment=new ArrayList<Integer>();

    //初始化Fragment
    private void prepareFragments(){

        fragments = new ArrayList<>();
        if (mPerCenterFragment == null){
           mPerCenterFragment = new PerCenterFragment();
        }
        fragments.add(mPerCenterFragment);


        if (mPerCenterSettingFragment == null){
            mPerCenterSettingFragment = new PerCenterSettingFragment();
        }
        fragments.add(mPerCenterSettingFragment);


        if (mPerCenterSettingSafeFragment == null){
            mPerCenterSettingSafeFragment = new PerCenterSettingSafeFragment();
        }
        fragments.add(mPerCenterSettingSafeFragment);

        if (mPerCenterEditFragment == null){
            mPerCenterEditFragment = new PerCenterEditFragment();
        }
        fragments.add(mPerCenterEditFragment);


    }

    //显示Fragment
    public void showFragment(int position) {

        loginCurrentFragment = position;

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        //先隐藏其他的
        for (int i = 0; i < fragments.size(); i++) {

            fragment = fragments.get(i);
            if (i == position) {
                transaction.replace(R.id.fl_per_center_main,fragment);
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
        return R.layout.fragment_per_center_main;
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
