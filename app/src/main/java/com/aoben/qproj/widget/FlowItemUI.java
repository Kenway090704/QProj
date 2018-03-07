package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/3/6 15:03
 * Email : xiaokai090704@126.com
 */

public class FlowItemUI extends LinearLayout {

    private Context context;

    public FlowItemUI(Context context) {
        super(context);

        this.context = context;

        initViews();
    }


    public FlowItemUI(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        initViews();
    }

    public FlowItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.item_flow, this);


    }

}
