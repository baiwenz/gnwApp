package com.example.mylibrary.fragment.Index;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.presenter.BasePresenter;
import com.example.commonlibrary.utils.MyStateBarUtil;
import com.example.commonlibrary.utils.WindowAttr;
import com.example.mylibrary.R;
import com.example.mylibrary.adapter.LocatAllAreaBRVAdapter;
import com.example.mylibrary.adapter.LocatHotSpotBRVAdapter;
import com.example.mylibrary.bean.AreaBean;
import com.example.mylibrary.bean.ProvinceBean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FragmentLocatArea extends BaseFragment implements View.OnClickListener {
    private LocatAreaActivity locatAreaActivity;
    private static FragmentLocatArea fragmentLocatArea;
    private FragmentSearch fragmentSearch;
    private RecyclerView hotSpotsRecyclerView,allRecyclerView;
    private LocatHotSpotBRVAdapter locatHotSpotBRVAdapter;
    private LocatAllAreaBRVAdapter locatAllAreaBRVAdapter;
    private List<AreaBean> listHotSpots;

    private ArrayList<MultiItemEntity> list;
    private ImageView returnImage;
    private TextView areaNowView;
    private TextView svSearch;

    public static FragmentLocatArea newInstance(String param1) {
        fragmentLocatArea = new FragmentLocatArea();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragmentLocatArea.setArguments(args);
        return fragmentLocatArea;
    }

    public FragmentLocatArea(){}
    @Override
    public void onClick(View v) {
          if(v.getId() == R.id.iv_search_return){

          }else if(v.getId() == R.id.sv_area){
              fragmentSearch = FragmentSearch.newInstance("搜索地区");
              locatAreaActivity.showFragment(fragmentSearch,null);
          }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.fragment_locat_area;
    }

    @Override
    public void initView(View view) {
        locatAreaActivity = (LocatAreaActivity) getActivity();
        returnImage = view.findViewById(R.id.iv_search_return);
        areaNowView = view.findViewById(R.id.tv_search_area);
        svSearch = view.findViewById(R.id.sv_area);

        initStatusBar(view);
        initAdapter(view);
    }

    @Override
    public void initData() {
        String areaNow =(String) getArguments().get("area1");
        areaNowView.setText(areaNow);
        returnImage.setOnClickListener(this);
        svSearch.setOnClickListener(this);
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
     * 设置热门地区的适配器和所以地区的适配器
     */
    private void initAdapter(View fragmentView){
        //绑定RecyclerView的头部
        View view =  LayoutInflater.from(getActivity()).inflate(R.layout.item_search_recyclerview_head,null,false);
        hotSpotsRecyclerView = view.findViewById(R.id.rv_search_hot_spots);
        allRecyclerView = fragmentView.findViewById(R.id.rv_search_area);


        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        hotSpotsRecyclerView.setLayoutManager(gridLayoutManager);
        locatHotSpotBRVAdapter = new LocatHotSpotBRVAdapter(R.layout.item_search_hot_spots,null);
        initHotData();
        hotSpotsRecyclerView.setAdapter(locatHotSpotBRVAdapter);

        list = generateData();
        locatAllAreaBRVAdapter = new LocatAllAreaBRVAdapter(list);
        allRecyclerView.setLayoutManager(new LinearLayoutManager(locatAreaActivity));
        allRecyclerView.setItemAnimator(new DefaultItemAnimator());
        locatAllAreaBRVAdapter.addHeaderView(view);

        locatAllAreaBRVAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String areaName = adapter.getItem(position).toString();


            }
        });
        allRecyclerView.setAdapter(locatAllAreaBRVAdapter);

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
        locatHotSpotBRVAdapter.addData(listHotSpots);
    }

    /**
     *  加载地区数据集
     * @return
     */
    public ArrayList<MultiItemEntity> generateData(){
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
