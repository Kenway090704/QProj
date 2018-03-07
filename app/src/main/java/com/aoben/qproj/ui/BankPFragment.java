package com.aoben.qproj.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.ui.adapter.BankPAdapter;
import com.aoben.qproj.ui.adapter.CustomLinerLayoutManager;
import com.aoben.qproj.util.LogUtils;

/**
 * Created by kenway on 18/2/28 11:04
 * Email : xiaokai090704@126.com
 * 银行产品
 */

public class BankPFragment extends BaseFragment {

    private RecyclerView rv;
    private BankPAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_bankp;
    }

    @Override
    protected void initViews(View root) {
//        rv = (RecyclerView) root.findViewById(R.id.frag_bankp_rv);

        LogUtils.e("初始化银行产品");
    }

    @Override
    protected void initEnvent() {

    }

    @Override
    protected void initData() {

//
//        adapter = new BankPAdapter(getContext());
//
//        CustomLinerLayoutManager linerLayoutManager=new CustomLinerLayoutManager(getContext());
//        linerLayoutManager.setScrollEnabled(false);
//        rv.setLayoutManager(linerLayoutManager);
////        rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        rv.setNestedScrollingEnabled(false);
//        rv.setAdapter(adapter);
    }
}
