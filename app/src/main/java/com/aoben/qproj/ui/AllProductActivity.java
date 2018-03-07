package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.ui.adapter.AllProductAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/6 10:44
 * Email : xiaokai090704@126.com
 * <p>
 * 全部产品页
 */

public class AllProductActivity extends DrawerBaseActivity {

    private RecyclerView rv;

    private List<ProductBean> list;


    private AllProductAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_allproduct;
    }

    @Override
    protected void initView() {

        rv = (RecyclerView) findViewById(R.id.acty_allproduct_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void initData() {


        list = new ArrayList<>();
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());
        list.add(new ProductBean());

        adapter = new AllProductAdapter(this, list);

        rv.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

    }


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AllProductActivity.class);

        context.startActivity(intent);
    }
}
