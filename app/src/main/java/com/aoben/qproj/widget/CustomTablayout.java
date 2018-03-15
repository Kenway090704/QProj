package com.aoben.qproj.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.util.Util;

/**
 * Created by HP on 2018/3/15.
 *
 */

public class CustomTablayout extends LinearLayout {

    private  Context context;
    private TextView tab1;
    private  TextView tab2;

    private int textSelectColor=R.color.com_tv_white_ffffff;
    private int textNoSelectColor=R.color.com_tv_orige_ff9600;

    private int bgSelect=R.drawable.shape_tab_bg_s;
    private int bgNoSelect=R.drawable.shape_tab_bg_n;

    private int  selectIndex=0;

    public CustomTablayout(Context context) {
        super(context);

        this.context=context;

        initViews();
    }

    public CustomTablayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;

        initViews();
    }

    public CustomTablayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_tablayout, this);
        tab1= (TextView) view.findViewById(R.id.custom_tablayout_tab1);
        tab2= (TextView) view.findViewById(R.id.custom_tablayout_tab2);

        tab1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectIndex==1){
                    selectIndex=0;
                    setSelect(selectIndex);
                    if (!Util.isNull(listener))
                        listener.onTabSelected(selectIndex);
                }
            }
        });

        tab2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectIndex==0){
                    selectIndex=1;
                    setSelect(selectIndex);
                    if (!Util.isNull(listener))
                    listener.onTabSelected(selectIndex);
                }
            }
        });

    }

    public void setSelect(int selectIndex) {
        this.selectIndex=selectIndex;
        if (selectIndex==0){
            tab2.setTextColor(getResources().getColor(textNoSelectColor));
            tab2.setBackgroundResource(bgNoSelect);
            tab1.setTextColor(getResources().getColor(textSelectColor));
            tab1.setBackgroundResource(bgSelect);
        }else {
            tab1.setTextColor(getResources().getColor(textNoSelectColor));
            tab1.setBackgroundResource(bgNoSelect);
            tab2.setTextColor(getResources().getColor(textSelectColor));
            tab2.setBackgroundResource(bgSelect);
        }

    }

    public void  setOnTabSelectedListener(OnTabSelectedListener listener){
        this.listener=listener;
    }

    private  OnTabSelectedListener listener;
    public  interface OnTabSelectedListener{
        void onTabSelected(int selectIndex);
    }
}
