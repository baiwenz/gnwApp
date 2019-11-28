package com.example.mylibrary.fragment.Index;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.MyStateBarUtil;
import com.example.commonlibrary.utils.WindowAttr;
import com.example.mylibrary.R;
import com.example.mylibrary.adapter.SearchAllAreaBRVAdapter;
import com.example.mylibrary.adapter.SearchAreaByInputBRVAdapter;
import com.example.mylibrary.adapter.SearchHotSpotBRVAdapter;
import com.example.mylibrary.bean.AreaBean;
import com.example.mylibrary.bean.ProvinceBean;
import com.example.mylibrary.fragment.HomeFragment;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class LocatAreaActivity extends BaseActivity {

    private RecyclerView hotSpotsRecyclerView,allRecyclerView;
    private SearchHotSpotBRVAdapter searchHotSpotBRVAdapter;
    private SearchAllAreaBRVAdapter searchAllAreaBRVAdapter;
    private SearchAreaByInputBRVAdapter searchAreaByInputBRVAdapter;
    private ImageView returnImage;
    private TextView areaNowView;
    private EditText etSearch;
    private RecyclerView searchAreaShow;
    private List<AreaBean> listHotSpots;
    private List<ProvinceBean.CityBean.AreasBean> listAreasBean;
    private ArrayList<MultiItemEntity> list;
    private FragmentManager manager;
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
        returnImage = findViewById(R.id.iv_search_return);
        areaNowView = findViewById(R.id.tv_search_area);
        etSearch = findViewById(R.id.et_area);
        searchAreaShow = findViewById(R.id.rv_search_area_show);
        //返回首页
        returnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        searchAreaShow.setLayoutManager(new LinearLayoutManager(this));
        searchAreaByInputBRVAdapter = new SearchAreaByInputBRVAdapter(R.layout.item_search_all_child_area,null);
        searchAreaByInputBRVAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(LocatAreaActivity.this,adapter.getItem(position).toString(),Toast.LENGTH_LONG).show();
            }
        });

        searchAreaShow.setAdapter(searchAreaByInputBRVAdapter);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                        search();
            }
        });


        initStatusBar();
        initAdapter();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String areaNow = bundle.getString("area");
        areaNowView.setText(areaNow);
    }

    /**
     * 设置状态栏
     */
    private void  initStatusBar(){
        //设置透明状态栏
        MyStateBarUtil.transparencyBar(this);
        View mStateBarFixer = findViewById( R.id.status_bar_fix);
        //填充状态栏
        mStateBarFixer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, WindowAttr.getStateBarHeight(this)));

    }

    /**
     * 设置热门地区的适配器和所以地区的适配器
     */
    private void initAdapter(){
        //绑定RecyclerView的头部
        View view =  LayoutInflater.from(this).inflate(R.layout.item_search_recyclerview_head,null,false);
        hotSpotsRecyclerView = view.findViewById(R.id.rv_search_hot_spots);
        allRecyclerView = findViewById(R.id.rv_search_area);


        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        hotSpotsRecyclerView.setLayoutManager(gridLayoutManager);
        searchHotSpotBRVAdapter = new SearchHotSpotBRVAdapter(R.layout.item_search_hot_spots,null);
        initHotData();
        hotSpotsRecyclerView.setAdapter(searchHotSpotBRVAdapter);

        list = generateData();
        searchAllAreaBRVAdapter = new SearchAllAreaBRVAdapter(list);
        allRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allRecyclerView.setItemAnimator(new DefaultItemAnimator());

        searchAllAreaBRVAdapter.addHeaderView(view);
        searchAllAreaBRVAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                FragmentTransaction  transaction = manager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                String areaName = adapter.getItem(position).toString();
                Bundle bundle = new Bundle();
                bundle.putString("areaIndexName",areaName);
                homeFragment.setArguments(bundle);
                /*transaction.replace(R.id.fl_main,homeFragment);*/
            }
        });
        allRecyclerView.setAdapter(searchAllAreaBRVAdapter);

    }

    /**
     * 加载热门地区数据
     */
    private void initHotData(){
        listHotSpots = new ArrayList<>();
        for(int i = 0;i<9;i++){
            AreaBean areaBean = new AreaBean();
            areaBean.setName("遵义"+i);
            listHotSpots.add(areaBean);
        }
        searchHotSpotBRVAdapter.addData(listHotSpots);
    }


    private void search() {
        listAreasBean = new ArrayList<>();
        String input = etSearch.getText().toString().trim();
        ArrayList<MultiItemEntity> list = generateData();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getItemType() == 1 && input.equals(list.get(i))){
                listAreasBean.add((ProvinceBean.CityBean.AreasBean)list.get(i));
            }
        }
        searchAreaByInputBRVAdapter.addData(listAreasBean);
    }



    /**
     *  加载地区数据集
     * @return
     */
    private ArrayList<MultiItemEntity> generateData(){
            String string = getFromAssets("city.txt");
            Log.i("json", string);
            List<ProvinceBean> provinceBeen = JSON.parseArray(string, ProvinceBean.class);
            List<ProvinceBean.CityBean> guizhouBean = new ArrayList<>();
            ArrayList<MultiItemEntity> res = new ArrayList<>();
            for(int i = 0;i<provinceBeen.size();i++){
                if(provinceBeen.get(i).provinceName.equals("贵州")){
                    guizhouBean = provinceBeen.get(i).citys;
                    for(int j = 0;j<guizhouBean.size();j++){
                        ProvinceBean.CityBean pbCityBean = new ProvinceBean.CityBean();
                        pbCityBean.cityId = guizhouBean.get(j).cityId;
                        pbCityBean.cityName = guizhouBean.get(j).cityName;
                        for(int k = 0; k < guizhouBean.get(j).areas.size();k++){
                            ProvinceBean.CityBean.AreasBean pbCBAreasBean = new ProvinceBean.CityBean.AreasBean();
                            pbCBAreasBean.areaId = guizhouBean.get(j).areas.get(k).areaId;
                            pbCBAreasBean.areaName = guizhouBean.get(j).areas.get(k).areaName;
                            pbCityBean.addSubItem(pbCBAreasBean);
                        }
                        res.add(pbCityBean);
                    }
                    break;

                }
            }
        return res;

    }

    /**
     * 从city.txt中获得所以地区的数据
     * @param fileName
     * @return
     */
    public String getFromAssets(String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            while ((line = bufReader.readLine()) != null)
                result.append(line);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
