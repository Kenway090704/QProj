package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/3/5 15:11
 * Email : xiaokai090704@126.com
 */

public class NavEditText extends LinearLayout {

    private Context context;
    private EditText et;
    private TextView tv_search;

    public NavEditText(Context context) {
        super(context);
        this.context = context;
        initViews();
    }


    public NavEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public NavEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.widget_nav_et, this);
        et = (EditText) view.findViewById(R.id.widget_nav_et_et);
        tv_search = (TextView) view.findViewById(R.id.widget_nav_tv_search);
    }


    public EditText getEditText() {
        return et;
    }


    public TextView getTextViewSearch() {
        return tv_search;
    }
}
