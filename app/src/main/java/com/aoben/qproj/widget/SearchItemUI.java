package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.ui.ProductDetailActivity;

/**
 * Created by kenway on 18/4/20 16:01
 * Email : xiaokai090704@126.com
 * <p>
 * 搜索结果展示
 */

public class SearchItemUI extends LinearLayout {

    private Context mContext;
    private TextView tv_name1;
    private TextView tv_name2;
    private TextView tv_condition_1;
    private TextView tv_condition_2;

    public SearchItemUI(Context context) {
        this(context, null);
//        mContext=context;
//        initViews();

    }

    public SearchItemUI(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//        mContext=context;
//        initViews();
    }

    public SearchItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }

    private void initViews() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_item, this);

        tv_name1 = (TextView) view.findViewById(R.id.search_item_tv_name_1);
        tv_name2 = (TextView) view.findViewById(R.id.search_item_tv_name_2);
        tv_condition_1 = (TextView) view.findViewById(R.id.search_item_tv_condition_1);
//        tv_condition_2 = (TextView) view.findViewById(R.id.search_item_tv_condition_2);

//        tv_name2.setTextColor(getResources().getColor(R.color.com_tv_black_333333));
    }


    public void setData(final ProductBean bean) {
        tv_name1.setText(bean.getTitle());

        tv_condition_1.setText(bean.getCondition());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailActivity.actionStart(mContext,bean);
            }
        });
    }




}
