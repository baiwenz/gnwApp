package com.example.mylibrary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.bean.Repo;
import com.example.mylibrary.R;
import com.example.mylibrary.presenter.HomePresenter;
import com.example.mylibrary.view.IHomeView;

@Route(path = Constance.HOME_FRAGMENT)
public class HomeFragment extends BaseFragment<IHomeView, HomePresenter<IHomeView>> implements IHomeView ,View.OnClickListener,View.OnFocusChangeListener{
    private static HomeFragment sHomeFragment;
    private Repo apiResult=new Repo();

//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        View view=inflater.inflate(R.layout.home_fragment,container,false);
//        return view;
//    }



    private void initGoods(){

    }

    private void initThings(){

    }

    public static HomeFragment newInstance(String param1) {
        sHomeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        sHomeFragment.setArguments(args);
        return sHomeFragment;
    }
    public HomeFragment() {

    }
    @Override
    protected HomePresenter<IHomeView> createPresenter() {
        return new HomePresenter<>();
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initData() {
        basePresenter.getHomeData();
    }

    @Override
    public void showhome(Repo apiResult) {
        this.apiResult=apiResult;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean b) {

    }

    @Override
    public void onError(Object result) {

    }
    @Override
    public void onClick(View v) {
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }
}