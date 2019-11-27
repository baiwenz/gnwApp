package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mylibrary.bean.AreaBean;

import java.util.List;

public class SearchAllAreaBRVAdapter extends BaseQuickAdapter<AreaBean, BaseViewHolder> {
    public SearchAllAreaBRVAdapter(int layoutResId, @Nullable List<AreaBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AreaBean item) {

    }
}
