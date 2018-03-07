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
import com.aoben.qproj.ui.adapter.SalesmanAdapter;
import com.aoben.qproj.ui.adapter.SalesmanDecoration;
import com.aoben.qproj.widget.QprojToolBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/2/6 14:58
 * Email : xiaokai090704@126.com
 * <p>
 * 业务员页面
 */

public class SalesmanActivity extends DrawerBaseActivity {


    private RecyclerView rv;


    private List<String> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_salesman;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();

        list.add("jj");
        list.add("jj");
        list.add("jj");
        list.add("jj");
        list.add("jj");
        list.add("jj");
        list.add("jj");
        list.add("jj");

        rv = (RecyclerView) findViewById(R.id.acty_salesman_rv);

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        rv.setAdapter(new SalesmanAdapter(this, list));



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
