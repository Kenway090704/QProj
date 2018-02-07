package com.aoben.qproj.ui;

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

public class SalesmanActivity extends BaseActivity {


    private DrawerLayout drawer;
    private QprojToolBar toolBar;
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

        rv.addItemDecoration(new SalesmanDecoration(7));

        rv.setAdapter(new SalesmanAdapter(this, list));


        toolBar = (QprojToolBar) findViewById(R.id.acty_salesman_toolbar);

        drawer= (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    @Override
    public void initData() {

    }

    @Override
    protected void initListener() {

        toolBar.getIv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(Gravity.LEFT)){
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });

    }
}
