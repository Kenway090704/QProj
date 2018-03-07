package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.util.UIHelper;

/**
 * Created by kenway on 18/3/6 11:20
 * Email : xiaokai090704@126.com
 */

public class ProductDetailItem extends LinearLayout {


    private Context context;

    private Button btn;

    public ProductDetailItem(Context context) {
        super(context);

        this.context = context;
        initViews();
    }

    public ProductDetailItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public ProductDetailItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.widget_pro_detail, this);

        btn = (Button) view.findViewById(R.id.widget_pro_detail_btn);


        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showDialog(context);
            }
        });
    }


}
