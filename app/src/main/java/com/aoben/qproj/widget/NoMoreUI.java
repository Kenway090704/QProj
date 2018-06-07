package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/5/9 14:06
 * Email : xiaokai090704@126.com
 */

public class NoMoreUI extends LinearLayout {
    private Context mContext;
    public NoMoreUI(Context context) {
        this(context,null);
    }

    public NoMoreUI(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NoMoreUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initViews();

    }

    public  void  initViews(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.no_more,this);

    }
}
