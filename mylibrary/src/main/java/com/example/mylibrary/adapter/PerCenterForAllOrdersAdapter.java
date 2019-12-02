package com.example.mylibrary.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.R;
import com.example.mylibrary.bean.MoreTypeBean;

import java.util.List;

public class PerCenterForAllOrdersAdapter extends RecyclerView.Adapter{

    private List<MoreTypeBean> mData;

    public PerCenterForAllOrdersAdapter(List<MoreTypeBean> mData){
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        //创建不同的 ViewHolder
        View view;
        //根据viewtype来判断
        if (viewType == RecyclerViewType.TYPE_PEND_PAYMENT){
            view = View.inflate(viewGroup.getContext(), R.layout.item_for_pend_payment,null);
            return new PendPaymentHolder(view);
        }else if (viewType == RecyclerViewType.TYPE_PEND_SHIP){
            view = View.inflate(viewGroup.getContext(), R.layout.item_for_pend_ship,null);
            return new PendShipHolder(view);
        }else if (viewType == RecyclerViewType.TYPE_SHIP){
            view = View.inflate(viewGroup.getContext(), R.layout.item_for_ship,null);
            return new ShipHolder(view);
        }else {
            view = View.inflate(viewGroup.getContext(), R.layout.item_for_pend_evaluation,null);
            return new PendEvaluationHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }


    @Override
    public int getItemCount() {
       return mData.size();
    }

    //重写getItemViewType方法 根据条件返回条目的类型
    @Override
    public int getItemViewType(int i) {
        //return super.getItemViewType(i);
        MoreTypeBean typeBean = mData.get(i);

        if (typeBean.type == 0){
            return RecyclerViewType.TYPE_PEND_PAYMENT;
        }else if (typeBean.type == 1){
            return RecyclerViewType.TYPE_PEND_SHIP;
        }else if (typeBean.type == 2){
            return RecyclerViewType.TYPE_SHIP;
        }else{
            return RecyclerViewType.TYPE_PEND_EVALUATION;
        }
    }

    //// 为了系统能够复用控件
    //创建不同的ViewHolder
    private class PendPaymentHolder extends RecyclerView.ViewHolder{
        public PendPaymentHolder(@NonNull View itemView) {
            super(itemView);
            //实例化该控件
        }
    }

    private class PendShipHolder extends RecyclerView.ViewHolder{
        public PendShipHolder(@NonNull View itemView) {
            super(itemView);
            //实例化该控件
        }
    }

    private class ShipHolder extends RecyclerView.ViewHolder{
        public ShipHolder(@NonNull View itemView) {
            super(itemView);
            //实例化该控件
        }
    }

    private class PendEvaluationHolder extends RecyclerView.ViewHolder{
        public PendEvaluationHolder(@NonNull View itemView) {
            super(itemView);
            //实例化该控件
        }
    }


}


