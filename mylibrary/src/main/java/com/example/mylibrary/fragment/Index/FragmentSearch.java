package com.example.mylibrary.fragment.Index;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.MyStateBarUtil;
import com.example.commonlibrary.utils.WindowAttr;
import com.example.mylibrary.R;
import com.example.mylibrary.adapter.SearchAreaBRVAdapter;
import com.example.mylibrary.bean.ProvinceBean;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends BaseFragment implements View.OnClickListener {
    private FragmentLocatArea fragmentLocatArea;
    private ImageView searchReturn;
    private EditText editText;
    private RecyclerView recyclerView;
    private static FragmentSearch fragmentSearch;
    private SearchAreaBRVAdapter searchAreaBRVAdapter;
    private List<ProvinceBean.CityBean.AreasBean> areasList;
    public static FragmentSearch newInstance(String param1) {
        fragmentSearch = new FragmentSearch();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragmentSearch.setArguments(args);
        return fragmentSearch;
    }

    public FragmentSearch(){}
    @Override
    public void onClick(View v) {

    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView(View view) {
        initStatusBar(view);
        fragmentLocatArea = new FragmentLocatArea();
        searchReturn = view.findViewById(R.id.iv_search_return);
        recyclerView = view.findViewById(R.id.rv_search_body);
        editText = view.findViewById(R.id.et_area);
        searchAreaBRVAdapter = new SearchAreaBRVAdapter(R.layout.item_search_all_child_area,null);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                initCounty();
            }
        });

        recyclerView.setAdapter(searchAreaBRVAdapter);
    }

    @Override
    public void initData() {

    }

    /**
     * 设置状态栏
     */
    private void  initStatusBar(View view){
        //设置透明状态栏
        MyStateBarUtil.transparencyBar(getActivity());
        View mStateBarFixer = view.findViewById( R.id.status_bar_fix);
        //填充状态栏
        mStateBarFixer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, WindowAttr.getStateBarHeight(getActivity())));

    }

    /**
     * 获得县级地区
     */
    private void initCounty(){
        ArrayList<MultiItemEntity> arrayList = fragmentLocatArea.generateData();
        areasList = new ArrayList<>();
        for(int i = 0;i < arrayList.size();i++){
            if(arrayList.get(i).getItemType() == 1){
                ProvinceBean.CityBean.AreasBean areasBean = (ProvinceBean.CityBean.AreasBean) arrayList.get(i);
                areasList.add(areasBean);
            }
        }
       searchAreaBRVAdapter.setNewData(areasList);
    }
}
