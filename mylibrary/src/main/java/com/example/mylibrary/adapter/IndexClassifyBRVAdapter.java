package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mylibrary.R;
import com.example.mylibrary.bean.IndexClassifyBean;


import java.util.List;

public class IndexClassifyBRVAdapter extends BaseQuickAdapter<IndexClassifyBean, BaseViewHolder> {
    public IndexClassifyBRVAdapter(int layoutResId, @Nullable List<IndexClassifyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, IndexClassifyBean item) {
        helper.setImageResource(R.id.iv_index_cla_pic,item.getClaPic());
        helper.setText(R.id.tv_index_cla_name,item.getClaName());
        helper.addOnClickListener(R.id.ll_index_cla);
    }
}
