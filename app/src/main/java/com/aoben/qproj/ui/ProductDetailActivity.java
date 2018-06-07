package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.widget.ScrollView;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.widget.ProductDetailItem;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by kenway on 18/3/6 11:17
 * Email : xiaokai090704@126.com
 */

public class ProductDetailActivity extends DrawerBaseActivity {

    private static final String PRODUCT = "product";

    private ScrollView scrollview;

    private ProductBean bean;

    private ProductDetailItem prodetail;

    @Override
    protected int getLayoutId() {
        bean = (ProductBean) getIntent().getSerializableExtra(PRODUCT);
        return R.layout.activity_prodetail;
    }

    @Override
    protected void initView() {
        prodetail= (ProductDetailItem) findViewById(R.id.acty_prodetail);
        scrollview= (ScrollView) findViewById(R.id.acty_prodetial_scrollview);
        //给控件设置弹性效果
//        OverScrollDecoratorHelper.setUpStaticOverScroll(scrollview, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }

    @Override
    public void initData() {

        prodetail.setData(bean);
    }

    @Override
    protected void initListener() {

    }

    public static void actionStart(Context context,ProductBean bean) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra(PRODUCT, bean);
        context.startActivity(intent);
    }
}
