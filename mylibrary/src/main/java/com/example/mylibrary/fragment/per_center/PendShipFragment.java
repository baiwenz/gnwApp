package com.example.mylibrary.fragment.per_center;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.R;
import com.example.mylibrary.adapter.PerCenterForOrdersAdapter;

public class PendShipFragment extends Fragment {

    private RecyclerView mRvOrders;

    public static PendShipFragment newInstance() {
        PendShipFragment fragment = new PendShipFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_per_center_orders, container, false);
        mRvOrders = rootView.findViewById(R.id.rv_orders);
        PerCenterForOrdersAdapter adapter = new PerCenterForOrdersAdapter(R.layout.item_for_pend_ship);
        mRvOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvOrders.setAdapter(adapter);
        return rootView;
    }


}
