package com.example.mylibrary.fragment.per_center;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.mylibrary.R;

public class TabLayoutForOrdersActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;

    private ViewPager viewPager;

    private String[] mTabTitles = {"全部","待付款","待发货","已发货","待评价"};

    private Fragment[] mFragmentArrays = new Fragment[mTabTitles.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab_layout_for_orders);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.tab_viewpager);
        initView();
    }

    private void initView() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = OrdersFragment.newInstance();
        mFragmentArrays[1] = OrdersFragment.newInstance();
        mFragmentArrays[2] = OrdersFragment.newInstance();
        mFragmentArrays[3] = OrdersFragment.newInstance();
        mFragmentArrays[4] = OrdersFragment.newInstance();
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }

}
