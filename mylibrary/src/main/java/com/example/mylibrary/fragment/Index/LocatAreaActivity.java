package com.example.mylibrary.fragment.Index;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mylibrary.R;
import com.example.mylibrary.adapter.SearchHotSpotBRVAdapter;
import com.example.mylibrary.bean.AreaBean;

import java.util.ArrayList;
import java.util.List;

public class LocatAreaActivity extends AppCompatActivity {
    private RecyclerView hotSpotsRecyclerView,allRecyclerView;
    private SearchHotSpotBRVAdapter searchHotSpotBRVAdapter;
    private List<AreaBean> listHotSpots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locat_area);
        hotSpotsRecyclerView = findViewById(R.id.rv_search_hot_spots);
        allRecyclerView = findViewById(R.id.rv_search_area);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        hotSpotsRecyclerView.setLayoutManager(gridLayoutManager);
        searchHotSpotBRVAdapter = new SearchHotSpotBRVAdapter(R.layout.item_search_hot_spots,null);
        initHotData();
        hotSpotsRecyclerView.setAdapter(searchHotSpotBRVAdapter);


        allRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
}
