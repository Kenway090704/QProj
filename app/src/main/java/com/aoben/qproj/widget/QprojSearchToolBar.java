package com.aoben.qproj.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/2/5 15:48
 * Email : xiaokai090704@126.com
 * 有搜索框的标题栏
 */

public class QprojSearchToolBar extends LinearLayout {


    private ImageView iv;
    private LinearLayout layout_back;

    private EditText et;

    private TextView tv_search;
    private Context mContext;

    public QprojSearchToolBar(Context context) {
        super(context);
        mContext = context;
        initViews();
    }

    public QprojSearchToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initViews();
    }

    public QprojSearchToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }


    private void initViews() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.toolbar_search_qproj, this);

        iv = (ImageView) findViewById(R.id.toolbar_iv);

        layout_back = (LinearLayout) findViewById(R.id.toolbar_iv_back);

        et= (EditText) findViewById(R.id.toolbar_search_et);

        tv_search= (TextView) findViewById(R.id.toolbar_tv_search);
        layout_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).finish();
            }
        });


    }


    public ImageView getIv() {
        return iv;
    }

    public LinearLayout getBackIv() {
        return layout_back;
    }
    public EditText getEditText() {
        return et;
    }
    public  TextView getTextView(){
        return tv_search;
    }
}
