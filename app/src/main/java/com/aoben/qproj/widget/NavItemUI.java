package com.aoben.qproj.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.util.Util;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by kenway on 18/3/5 14:18
 * Email : xiaokai090704@126.com
 */

public class NavItemUI extends LinearLayout {

    private Context context;

    private RoundedImageView riv;
    private TextView tv;

    private String name;

    public NavItemUI(Context context) {
        super(context);
        this.context = context;
        initViews();
    }


    public NavItemUI(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.NavItemUI);
        name = array.getString(R.styleable.NavItemUI_nav_name);
        array.recycle();
        this.context = context;
        initViews();


    }

    public NavItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.item_nav, this);

        riv = (RoundedImageView) view.findViewById(R.id.item_nav_riv);
        tv = (TextView) view.findViewById(R.id.item_nav_tv);

        if (!Util.isNullOrBlank(name))
            tv.setText(name);
    }


    public ImageView getRoundImageView() {
        return riv;
    }
}
