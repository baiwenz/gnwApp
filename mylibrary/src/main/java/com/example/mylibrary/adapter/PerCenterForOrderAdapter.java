package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.R;

public class PerCenterForOrderAdapter extends RecyclerView.Adapter<PerCenterForOrderAdapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 指定对应的布局文件
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_for_all_orders, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
       return 5;
    }

    //// 为了系统能够复用控件
    static class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //实例化该控件
        }
    }

}


