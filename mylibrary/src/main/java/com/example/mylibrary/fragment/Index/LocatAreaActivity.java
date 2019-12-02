package com.example.mylibrary.fragment.Index;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;
import com.example.mylibrary.fragment.Index.FragmentLocatArea;
import com.example.mylibrary.fragment.Index.FragmentSearch;


public class LocatAreaActivity extends BaseActivity {


    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private FragmentLocatArea fragmentLocatArea;
    private FragmentSearch fragmentSearch;

    public void showFragment(Fragment fragment,Bundle bundle){
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment.setArguments(bundle);
        transaction.replace(R.id.fl_locat_area,fragment);
        if(fragment!= fragmentLocatArea) transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.activity_locat_area;
    }

    @Override
    public void initView() {
        fragmentLocatArea = FragmentLocatArea.newInstance("选择地区");
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String areaNow = bundle.getString("area");
        Bundle bundle1 = new Bundle();
        bundle1.putString("area1",areaNow);
        showFragment(fragmentLocatArea,bundle1);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
