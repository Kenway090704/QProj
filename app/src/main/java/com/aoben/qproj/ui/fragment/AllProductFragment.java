package com.aoben.qproj.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.ui.BaseFragment;
import com.aoben.qproj.ui.adapter.AllProductAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/12 11:49
 * Email : xiaokai090704@126.com
 */

public class AllProductFragment extends BaseFragment {

    private RecyclerView  rv;

    private List<ProductBean> list;
    private AllProductAdapter adapter;
    @Override
    protected int getLayoutId() {

        return R.layout.frag_allp;
    }

    @Override
    protected void initViews(View root) {

        rv= (RecyclerView) root.findViewById(R.id.frag_allproduct_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void initEnvent() {

    }

    @Override
    protected void initData() {
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

        adapter = new AllProductAdapter(getContext(), list);

        rv.setAdapter(adapter);
    }
}
