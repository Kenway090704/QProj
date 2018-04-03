package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.ui.adapter.SalesmanAdapter;
import com.aoben.qproj.ui.adapter.SalesmanDecoration;
import com.aoben.qproj.ui.hongyang.CommonAdapter;
import com.aoben.qproj.ui.hongyang.ViewHolder;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.SalerItemUI;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by kenway on 18/2/6 14:58
 * Email : xiaokai090704@126.com
 * <p>
 * 业务员页面
 */

public class SalesmanActivity extends DrawerBaseActivity {


    private RecyclerView rv;


    private List<SalerBean> list;
    private CommonAdapter<SalerBean> adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_salesman;
    }

    @Override
    protected void initView() {


        QpRetrofitManager.getInstance().getSalers().subscribe(new BaseObServer<List<SalerBean>>() {
            @Override
            public void onHandleSuccess(List<SalerBean> salerBeens) {
                if (Util.isNull(salerBeens)||salerBeens.size()==0){

                }else {
                    LogUtils.e("salerBeans==" + salerBeens.toString());
                    list = new ArrayList<>();
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);
                    list.addAll(salerBeens);

                    adapter = new CommonAdapter<SalerBean>(SalesmanActivity.this, R.layout.adapter_saler, list) {
                        @Override
                        public void convert(ViewHolder holder, SalerBean s) {
                            SalerItemUI siu = holder.getView(R.id.adapter_saler_siu);
                            siu.setData(s);
                        }
                    };
                    rv.setAdapter(adapter);
                }

            }
        });


        rv = (RecyclerView) findViewById(R.id.acty_salesman_rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void initData() {

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SalesmanActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initListener() {


    }


}
