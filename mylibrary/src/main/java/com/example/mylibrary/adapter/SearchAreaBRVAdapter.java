package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mylibrary.R;
import com.example.mylibrary.bean.ProvinceBean;

import java.util.List;

public class SearchAreaBRVAdapter extends BaseQuickAdapter<ProvinceBean.CityBean.AreasBean, BaseViewHolder> {
    public SearchAreaBRVAdapter(int layoutResId, @Nullable List<ProvinceBean.CityBean.AreasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProvinceBean.CityBean.AreasBean item) {
            helper.setText(R.id.tv_search_child_area_name,item.areaName);
    }
}
