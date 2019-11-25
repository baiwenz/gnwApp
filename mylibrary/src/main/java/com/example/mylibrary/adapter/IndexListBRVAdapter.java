package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mylibrary.R;
import com.example.mylibrary.bean.ListProductionBean;

import java.util.List;

public class IndexListBRVAdapter extends BaseQuickAdapter<ListProductionBean, BaseViewHolder> {
    public IndexListBRVAdapter(int layoutResId, @Nullable List<ListProductionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ListProductionBean item) {
        helper.setImageResource(R.id.iv_item_pic,item.getPic());
        helper.setText(R.id.tv_item_name,item.getName());
        helper.setText(R.id.tv_item_price_now,"$"+item.getPrice_now());
        helper.setText(R.id.tv_item_price_past,"$"+item.getPrice_post());
        helper.setText(R.id.tv_item_similar,"找相似");
        helper.addOnClickListener(R.id.ll_index_list);
    }
}
