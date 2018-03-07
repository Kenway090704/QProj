package com.aoben.qproj.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aoben.qproj.R;
import com.aoben.qproj.util.ResourceUtil;
import com.aoben.qproj.widget.SalerItemUI;

import java.util.List;

/**
 * Created by kenway on 18/2/6 17:28
 * Email : xiaokai090704@126.com
 * 业务员adapter
 */

public class SalesmanAdapter extends RecyclerView.Adapter<SalesmanAdapter.SalesmanViewHolder> {

    private Context context;
    private List<String> list;

    public SalesmanAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SalesmanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SalesmanViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_saler, null));
    }

    @Override
    public void onBindViewHolder(SalesmanViewHolder holder, int position) {


        if (position == 0) {
            holder.siu.setLayoutTool(View.VISIBLE, ResourceUtil.resToStr(R.string.saler), null);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SalesmanViewHolder extends RecyclerView.ViewHolder {

        private SalerItemUI siu;

        public SalesmanViewHolder(View itemView) {
            super(itemView);

            siu = (SalerItemUI) itemView.findViewById(R.id.adapter_saler_siu);
        }
    }
}
