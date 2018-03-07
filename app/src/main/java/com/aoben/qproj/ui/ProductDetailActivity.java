package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceActivity;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/3/6 11:17
 * Email : xiaokai090704@126.com
 */

public class ProductDetailActivity extends DrawerBaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_prodetail;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void initListener() {

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        context.startActivity(intent);
    }
}
