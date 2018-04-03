package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;

/**
 * Created by kenway on 18/3/29 15:09
 * Email : xiaokai090704@126.com
 */

public class StarUI extends LinearLayout {

    private Context context;

    private ImageView iv_01,iv_02,iv_03,iv_04,iv_05;
    public StarUI(Context context) {
        super(context);

        this.context=context;

        initViews();
    }

    public StarUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initViews();
    }

    public StarUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;

        initViews();
    }

    private void initViews() {

        View view= LayoutInflater.from(context).inflate(R.layout.widget_star,this);

        iv_01= (ImageView) view.findViewById(R.id.widget_start_1);
        iv_02= (ImageView) view.findViewById(R.id.widget_start_2);
        iv_03= (ImageView) view.findViewById(R.id.widget_start_3);
        iv_04= (ImageView) view.findViewById(R.id.widget_start_4);
        iv_05= (ImageView) view.findViewById(R.id.widget_start_5);

        iv_01.setVisibility(GONE);
        iv_02.setVisibility(GONE);
        iv_03.setVisibility(GONE);
        iv_04.setVisibility(GONE);
        iv_05.setVisibility(GONE);
    }


    public void setStarCount(String starCount){
        switch (starCount){
            case  "0":
                iv_01.setVisibility(GONE);
                iv_02.setVisibility(GONE);
                iv_03.setVisibility(GONE);
                iv_04.setVisibility(GONE);
                iv_05.setVisibility(GONE);
                break;
            case  "1":
                iv_01.setVisibility(VISIBLE);
                iv_02.setVisibility(GONE);
                iv_03.setVisibility(GONE);
                iv_04.setVisibility(GONE);
                iv_05.setVisibility(GONE);
                break;
            case "2":
                iv_01.setVisibility(VISIBLE);
                iv_02.setVisibility(VISIBLE);
                iv_03.setVisibility(GONE);
                iv_04.setVisibility(GONE);
                iv_05.setVisibility(GONE);
                break;
            case "3":
                iv_01.setVisibility(VISIBLE);
                iv_02.setVisibility(VISIBLE);
                iv_03.setVisibility(VISIBLE);
                iv_04.setVisibility(GONE);
                iv_05.setVisibility(GONE);
                break;
            case "4":
                iv_01.setVisibility(VISIBLE);
                iv_02.setVisibility(VISIBLE);
                iv_03.setVisibility(VISIBLE);
                iv_04.setVisibility(VISIBLE);
                iv_05.setVisibility(GONE);
                break;
            case "5":
                iv_01.setVisibility(VISIBLE);
                iv_02.setVisibility(VISIBLE);
                iv_03.setVisibility(VISIBLE);
                iv_04.setVisibility(VISIBLE);
                iv_05.setVisibility(VISIBLE);
                break;
        }

    }


}
