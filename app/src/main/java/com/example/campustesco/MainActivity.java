package com.example.campustesco;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.fragment.HomeFragment;
import com.example.mylibrary.fragment.MessageFragment;
import com.example.mylibrary.fragment.MyFragment;
import com.example.mylibrary.fragment.ShopCarFragment;

import java.util.ArrayList;
import static com.example.commonlibrary.base.Constants.currentFragment;

public class MainActivity extends BaseActivity {
    private ArrayList<Fragment> fragments;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private HomeFragment mHomeFragment; //首页
    private MyFragment mMyFragment; //个人中心
    private ShopCarFragment mShopCarFragment; //购物车
    private MessageFragment mMessageFragment; //消息
    /** 作用：底部导航栏监听
     ** 日期：2019年4月15日
     **/

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(0);
                    return true;
                case R.id.navigation_message:
                    showFragment(1);
                    return true;
                case R.id.navigation_shopcar:
                    showFragment(2);
                    return true;
                case R.id.navigation_my:
                    showFragment(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected int initLayoutInflater() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        prepareFragments();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        navigation.setSelectedItemId(R.id.navigation_home);
    }


    @Override
    public void initData() {
        showFragment(0);

    }

    private void prepareFragments() {
        fragments = new ArrayList<>();
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstance("首页");
        }
        fragments.add(mHomeFragment);

        if (mMessageFragment ==null){
            mMessageFragment=MessageFragment.newInstance("消息");
        }
        fragments.add(mMessageFragment);

        if (mShopCarFragment ==null){
            mShopCarFragment=ShopCarFragment.newInstance("购物车");
        }
        fragments.add(mShopCarFragment);
        if (mMyFragment == null) {
            mMyFragment = MyFragment.newInstance("个人中心");
        }
        fragments.add(mMyFragment);



    }

    public void showFragment(int position) {
        currentFragment = position;
        FragmentManager fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        //先隐藏其他的
        for (int i = 0; i < fragments.size(); i++) {
            fragment = fragments.get(i);
            if (i == position) {
                if (fragment.isAdded()) {
                    transaction.show(fragment);
                } else {
                    //add
                    transaction.add(R.id.fl_main, fragment);
                }
            } else {
                if (fragment.isAdded()) {
                    transaction.hide(fragment);
                }
            }
        }
        //commit
        transaction.commitAllowingStateLoss();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1002) {
            mMyFragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}