package com.example.mylibrary.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.ARouter.LoginNavigationCallbackImpl;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.ARouter.Constance;
import com.example.commonlibrary.bean.ApiResult;
import com.example.commonlibrary.utils.EditText_Clear;
import com.example.commonlibrary.utils.UnScrollListView;
import com.example.commonlibrary.bean.IndexMenu;
import com.example.mylibrary.R;
import com.example.mylibrary.presenter.HomePresenter;
import com.example.mylibrary.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

@Route(path = Constance.HOME_FRAGMENT)
public class HomeFragment extends BaseFragment<IHomeView, HomePresenter<IHomeView>> implements IHomeView ,View.OnClickListener,View.OnFocusChangeListener{
    private static HomeFragment sHomeFragment;
    private EditText_Clear mEditText_clear;
    private LinearLayout mSearch_box;
    private UnScrollListView list_gus_you_like;
    private GridView grid_index_menu;
    private ApiResult apiResult=new ApiResult();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        initGoods();
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        initThings();
        RecyclerView recyclerView1=(RecyclerView)view.findViewById(R.id.recycler_view2);
        StaggeredGridLayoutManager layoutManager1=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager1);
        return view;
    }



    private void initGoods(){

    }

    private void initThings(){

    }

    public static HomeFragment newInstance(String param1) {
        sHomeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        sHomeFragment.setArguments(args);
        return sHomeFragment;
    }
    public HomeFragment() {

    }
    private void setGusYouLikeAdapterList(){
       ;
    }
    private void setIndexMenuAdapterList(){
    }
    private List<IndexMenu> getIndexMenuData(){
        List<IndexMenu> indexMenus=new ArrayList<>();
        for(int i=0;i<10;i++){
            IndexMenu indexMenu=new IndexMenu();
            indexMenu.setTitle("菜单"+i);
            indexMenus.add(indexMenu);
        }
        return indexMenus;
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
//        list_gus_you_like=view.findViewById(R.id.list_gus_you_like);
        mEditText_clear=view.findViewById(R.id.et_search);
        mSearch_box=view.findViewById(R.id.et_searchbox);
        list_gus_you_like.setFocusable(false);
    }

    @Override
    public void initData() {
        basePresenter.getHomeData();
        mEditText_clear.setOnClickListener(this);
        mEditText_clear.setOnFocusChangeListener(this);
        setIndexMenuAdapterList();
        setGusYouLikeAdapterList();
    }

    @Override
    public void showhome(ApiResult apiResult) {
        this.apiResult=apiResult;
        setGusYouLikeAdapterList();
        Toast.makeText(getActivity(), apiResult.toString(), Toast.LENGTH_SHORT).show();
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
        if (v.getId()==R.id.et_search){
            ARouter.getInstance()
                    .build(Constance.SEARCH_ACTIVITY)
                    .navigation(getActivity(),new LoginNavigationCallbackImpl());
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }
}