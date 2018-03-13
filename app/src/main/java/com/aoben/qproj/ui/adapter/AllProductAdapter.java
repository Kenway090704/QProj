package com.aoben.qproj.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.ui.ProductDetailActivity;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.ResourceUtil;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.ProductDetailItem;
import com.aoben.qproj.widget.ProductItemUI;

import java.util.List;

/**
 * Created by kenway on 18/3/6 10:48
 * Email : xiaokai090704@126.com
 * <p>
 * 全部产品页Adapter
 */

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.MyViewHolder> {

    private Context context;
    private List<ProductBean> listData;

    public AllProductAdapter(Context context, List<ProductBean> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_allp, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        if (position == 0) {
//            holder.productItemUI.setLayoutTool(View.GONE, ResourceUtil.resToStr(R.string.all_product), null);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailActivity.actionStart(v.getContext());
            }
        });

    }

    @Override
    public int getItemCount() {
int size=Util.isNull(listData) ? 0 : listData.size();

        return Util.isNull(listData) ? 0 : listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private ProductItemUI productItemUI;

        public MyViewHolder(View itemView) {
            super(itemView);

            productItemUI = (ProductItemUI) itemView.findViewById(R.id.adapter_allp_piu);
        }
    }
}
