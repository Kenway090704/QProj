package com.aoben.qproj.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.util.UIHelper;

/**
 * Created by kenway on 18/3/6 11:20
 * Email : xiaokai090704@126.com
 */

public class ProductDetailItem extends LinearLayout {


    private Context context;

    private TextView tv_interest, tv_limit, tv_year;


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
        tv_interest = (TextView) findViewById(R.id.widget_pro_detail_tv_interst);
        tv_limit = (TextView) findViewById(R.id.widget_pro_detail_tv_limit);
        tv_year = (TextView) findViewById(R.id.widget_pro_detail_tv_year);
        btn = (Button) view.findViewById(R.id.widget_pro_detail_btn);


        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                UIHelper.showDialog(context);

                UIHelper.showKonwDialog(context);
            }
        });

        setData();
    }

    public void setData() {
        setTextColor(tv_interest, "0.629%", "%", 0.435f);
        setTextColor(tv_limit, "1000万", "万", 0.435f);
        setTextColor(tv_year, "3年", "年", 0.435f);
    }


    /**
     * 改变字体颜色和大小
     *
     * @param tv
     * @param base   原字符串
     * @param change "%"  改变样式的字符串
     * @param size   33/13= 0.394  20/13= 0.65   23/10=0.435
     */
    private void setTextColor(TextView tv, String base, String change, float size) {

        int index = base.indexOf(change);
        if (index == -1) return;


        SpannableString spannableString = new SpannableString(base);

        //设置大小 0.65   0.394
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(size);
        spannableString.setSpan(sizeSpan01, index, index + change.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        tv.setText(spannableString);


    }


}
