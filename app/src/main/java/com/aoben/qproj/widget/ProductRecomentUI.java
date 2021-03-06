package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductConfig;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.ui.AllProductActivity;
import com.aoben.qproj.ui.ProductDetailActivity;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.ResourceUtil;

import java.util.List;

/**
 * Created by kenway on 18/3/5 13:57
 * Email : xiaokai090704@126.com
 */

public class ProductRecomentUI extends LinearLayout {

    private Context context;

    private ProductItemUI pui_01, pui_02, pui_03;

    public ProductRecomentUI(Context context) {
        super(context);
        this.context = context;
        initViews();
    }


    public ProductRecomentUI(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        initViews();
    }

    public ProductRecomentUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.widget_allp, this);
        pui_01 = (ProductItemUI) view.findViewById(R.id.widget_allp_pui_01);
        pui_02 = (ProductItemUI) view.findViewById(R.id.widget_allp_pui_02);
        pui_03 = (ProductItemUI) view.findViewById(R.id.widget_allp_pui_03);




    }


    public void setData(final List<ProductBean> list, final int product_style) {


        pui_01.setData(list.get(0));
        pui_02.setData(list.get(1));
        pui_03.setData(list.get(2));

        pui_01.setLayoutTool(View.VISIBLE, ResourceUtil.resToStr(R.string.all_product), new OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入y银行产品列表页
                AllProductActivity.actionStart(context, product_style);
            }
        });


        pui_01.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailActivity.actionStart(context,list.get(0));
            }
        });


        pui_02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailActivity.actionStart(context,list.get(1));
            }
        });


        pui_03.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailActivity.actionStart(context,list.get(2));
            }
        });
    }

}
