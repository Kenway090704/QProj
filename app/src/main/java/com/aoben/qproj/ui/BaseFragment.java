package com.aoben.qproj.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HanLei on 2016/8/10 0010.
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 根布局
     */
    protected View root;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 加载根布局
        root = inflater.inflate(getLayoutId(), null);
        // 初始化控件
        initViews(root);
        initViews(root, savedInstanceState);
        // 初始化监听事件
        initEnvent();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        // 初始化数据
        initData();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    /**
     * 获取布局的id
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initViews(View root);

    /**
     * 为了传递参数
     *
     * @param root
     * @param savedInstanceState
     */
    protected void initViews(View root, @Nullable Bundle savedInstanceState) {

    }

    /**
     * 初始化视图的监听事件
     */
    protected abstract void initEnvent();

    /**
     * 初始化数据
     */
    protected abstract void initData();


}
