package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mylibrary.R;
import com.example.mylibrary.bean.AreaBean;

import java.util.List;

public class LocatHotSpotBRVAdapter extends BaseQuickAdapter<AreaBean, BaseViewHolder> {
    public LocatHotSpotBRVAdapter(int layoutResId, @Nullable List<AreaBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AreaBean item) {
                helper.setText(R.id.tv_item_search_hot_spots,item.getName()).addOnClickListener(R.id.tv_item_search_hot_spots);
    }
}
