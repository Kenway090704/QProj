package com.aoben.qproj.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.SalerBean;

import java.util.List;

/**
 * Created by kenway on 18/2/28 11:41
 * Email : xiaokai090704@126.com
 * 银行产品Adapter
 */

public class BankPAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<ProductBean> productBeens;
    private List<SalerBean> salerBeens;

    private static int TYPE_ALLP = 0;
    private static int TYPE_SALER = 1;

    public BankPAdapter(Context context) {
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ALLP) {
            View view = LayoutInflater.from(context).inflate(R.layout.widget_allp, parent, false);
            return new AllPViewHolder(view);
        } else if (viewType == TYPE_SALER) {
            View view = LayoutInflater.from(context).inflate(R.layout.widget_saler, parent, false);
            return new SalerViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (position < 3) {
            AllPViewHolder allPViewHolder = (AllPViewHolder) holder;

        } else {
            SalerViewHolder salerViewHolder = (SalerViewHolder) holder;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 3) {
            return TYPE_ALLP;
        } else {
            return TYPE_SALER;
        }

    }

    public class AllPViewHolder extends RecyclerView.ViewHolder {

        public AllPViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class SalerViewHolder extends RecyclerView.ViewHolder {

        public SalerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
