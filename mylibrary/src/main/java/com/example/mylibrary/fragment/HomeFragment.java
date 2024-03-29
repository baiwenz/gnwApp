package com.example.mylibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.utils.MyStateBarUtil;
import com.example.commonlibrary.utils.Result;
import com.example.commonlibrary.utils.WindowAttr;
import com.example.mylibrary.R;
import com.example.mylibrary.adapter.IndexClassifyBRVAdapter;
import com.example.mylibrary.adapter.IndexListBRVAdapter;
import com.example.mylibrary.bean.IndexClassifyBean;
import com.example.mylibrary.bean.ListProductionBean;

import com.example.mylibrary.fragment.Index.LocatAreaActivity;
import com.example.mylibrary.model.GlideImageLoader;
import com.example.mylibrary.presenter.HomePresenter;
import com.example.mylibrary.view.IHomeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

@Route(path = Constance.HOME_FRAGMENT)
public class HomeFragment extends BaseFragment<IHomeView, HomePresenter<IHomeView>> implements IHomeView ,View.OnClickListener,View.OnFocusChangeListener{
    private static HomeFragment sHomeFragment;
    private Result result=new Result();
    private TextView tvIndexHeadArea;
    private SmartRefreshLayout smartRefreshLayout;
    private IndexListBRVAdapter adapter;
    private IndexClassifyBRVAdapter classifyBRVAdapter;
    private RecyclerView recyclerView,indexHoriRecyclerView;
    private List<ListProductionBean> data;
    private List<IndexClassifyBean> indexClassdata;


    public static HomeFragment newInstance(String param1) {
        sHomeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        sHomeFragment.setArguments(args);
        return sHomeFragment;
    }
    public HomeFragment() {

    }
    @Override
    protected HomePresenter<IHomeView> createPresenter() {
        return new HomePresenter<>();
    }

    @Override
    protected int initLayoutInflater() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView(View view) {
        tvIndexHeadArea = view.findViewById(R.id.tv_index_head_area);
        init(view);

    }

    /**
     * 轮播图
     */
    private void initSlideShow(View view){
        //StaggeredGridLayoutManager layoutManager1=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        List images = new ArrayList();
        images.add(R.drawable.index_fruit);
        images.add(R.drawable.bottle);
        images.add(R.drawable.ic_delete);

        Banner banner = view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);

        //banner设置方法全部调用完毕时最后调用
        banner.start();

        //增加点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                    Toast.makeText(getActivity(),"hahaha"+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 上拉刷新，下拉加载;商品展示列表RecyclerView配置适配器;
     */
    private void init(View view){
        //设置上拉刷新和下拉加载
        smartRefreshLayout = view.findViewById(R.id.smart_refresh);
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        smartRefreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initThings();
                refreshLayout.finishRefresh(1000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                initThings();
                refreshLayout.finishLoadMore(1000);
            }
        });

        //将状态栏设置透明，并填充状态栏
        MyStateBarUtil.transparencyBar(getActivity());
        View mStateBarFixer = view.findViewById( R.id.status_bar_fix);
        //填充状态栏
        mStateBarFixer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, WindowAttr.getStateBarHeight(getActivity())));

        //绑定适配器
        recyclerView = view.findViewById(R.id.rv_index_content);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new IndexListBRVAdapter(R.layout.item_fruit_home,null);
        View connectHead = LayoutInflater.from(getActivity()).inflate(R.layout.item_index_head,null,false);
        initSlideShow(connectHead);
        initIndexHoriClassify(connectHead);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(),"我是商品"+position,Toast.LENGTH_LONG).show();
            }
        });
        adapter.addHeaderView(connectHead);
        initThings();
        recyclerView.setAdapter(adapter);


    }

    /**
     * 商品分类横向RecyclerView配置适配器
     */
    private void initIndexHoriClassify(View view){
        indexHoriRecyclerView = view.findViewById(R.id.rv_index_hori_classify);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        indexHoriRecyclerView.setLayoutManager(manager);
        classifyBRVAdapter = new IndexClassifyBRVAdapter(R.layout.item_index_classify,null);
        initIndexClassify();
        classifyBRVAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(),"我是分类模块"+position,Toast.LENGTH_LONG).show();
            }
        });
        indexHoriRecyclerView.setAdapter(classifyBRVAdapter);
    }


    @Override
    public void initData() {
        basePresenter.getHomeData();
        tvIndexHeadArea.setOnClickListener(this);
    }

    @Override
    public void showhome(Result result) {
        this.result=result;
        Toast.makeText(getActivity(),result.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean b) {

    }

    @Override
    public void onError(Object result) {

    }
    @Override
    public void onClick(View v) {
       if(v.getId() == R.id.tv_index_head_area){
           Intent intent = new Intent(getActivity(), LocatAreaActivity.class);
           Bundle bundle = new Bundle();
           String area = (String) tvIndexHeadArea.getText();
           bundle.putString("area",area);
           intent.putExtras(bundle);
           startActivity(intent);
       }

    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }

    private void initThings(){
        data = new ArrayList<>();
        for(int i = 0;i<10;i++){
            String area = (String) tvIndexHeadArea.getText();
            ListProductionBean listProductionBean = new ListProductionBean();
            listProductionBean.setName(area+":商品"+i);
            listProductionBean.setPic(R.drawable.heiheihei);
            listProductionBean.setPrice_now(20.23+i);
            listProductionBean.setPrice_post(100.00);
            data.add(listProductionBean);
        }
        adapter.addData(data);
    }

    private void initIndexClassify(){
        indexClassdata = new ArrayList<>();
        for(int i = 0;i<20;i++){
            IndexClassifyBean indexClassifyBean = new IndexClassifyBean();
            indexClassifyBean.setClaName("威宁"+i);
            indexClassifyBean.setClaPic(R.drawable.module_fruit2);
            indexClassdata.add(indexClassifyBean);
        }
        classifyBRVAdapter.addData(indexClassdata);
    }


}