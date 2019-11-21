package com.example.mylibrary.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.mylibrary.R;

public class MessageFragment extends BaseFragment {
    private static MessageFragment sMessageFragment;

    public static MessageFragment newInstance(String param1) {
        sMessageFragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        sMessageFragment.setArguments(args);
        return sMessageFragment;
    }

    public MessageFragment() {
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.message_fragment;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
