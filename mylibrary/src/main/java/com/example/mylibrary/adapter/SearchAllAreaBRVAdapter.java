package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.mylibrary.R;
import com.example.mylibrary.bean.ProvinceBean;

import java.util.List;

public class SearchAllAreaBRVAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = SearchAllAreaBRVAdapter.class.getSimpleName();
    private TextView lookingWhere;
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public SearchAllAreaBRVAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_search_all_parent_area);
        addItemType(TYPE_LEVEL_1, R.layout.item_search_all_child_area);

    }

    @Override
    protected void convert(@NonNull final BaseViewHolder helper, final MultiItemEntity item) {
            switch (helper.getItemViewType()){
                case TYPE_LEVEL_0:
                    final ProvinceBean.CityBean cityBean = (ProvinceBean.CityBean)item;
                    helper.setText(R.id.tv_search_parent_area_name,((ProvinceBean.CityBean) item).cityName);
                    helper.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int pos = helper.getAdapterPosition();

                            if(cityBean.isExpanded()){
                                collapse(pos);
                            }else {
                                expand(pos);
                            }
                        }
                    });
                    break;
                case TYPE_LEVEL_1:
                    final ProvinceBean.CityBean.AreasBean areasBean = (ProvinceBean.CityBean.AreasBean)item;
                    helper.setText(R.id.tv_search_child_area_name,((ProvinceBean.CityBean.AreasBean) item).areaName).addOnClickListener(R.id.tv_search_child_area_name);

                    break;
                    default:
                        break;
            }
    }
}
