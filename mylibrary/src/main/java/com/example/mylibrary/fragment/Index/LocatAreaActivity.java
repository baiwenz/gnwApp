package com.example.mylibrary.fragment.Index;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.commonlibrary.utils.MyStateBarUtil;
import com.example.commonlibrary.utils.WindowAttr;
import com.example.mylibrary.R;
import com.example.mylibrary.adapter.SearchAllAreaBRVAdapter;
import com.example.mylibrary.adapter.SearchHotSpotBRVAdapter;
import com.example.mylibrary.bean.AreaBean;
import com.example.mylibrary.bean.ProvinceBean;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class LocatAreaActivity extends AppCompatActivity {

    private RecyclerView hotSpotsRecyclerView,allRecyclerView;
    private SearchHotSpotBRVAdapter searchHotSpotBRVAdapter;
    private SearchAllAreaBRVAdapter searchAllAreaBRVAdapter;
    private List<AreaBean> listHotSpots;
    private ArrayList<MultiItemEntity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locat_area);
        //设置透明状态栏
        MyStateBarUtil.transparencyBar(this);
        View mStateBarFixer = findViewById( R.id.status_bar_fix);
        //填充状态栏
        mStateBarFixer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, WindowAttr.getStateBarHeight(this)));

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
        allRecyclerView.setAdapter(searchAllAreaBRVAdapter);


    }

    private void initHotData(){
        listHotSpots = new ArrayList<>();
        for(int i = 0;i<9;i++){
            AreaBean areaBean = new AreaBean();
            areaBean.setName("遵义"+i);
            listHotSpots.add(areaBean);
        }
        searchHotSpotBRVAdapter.addData(listHotSpots);
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
