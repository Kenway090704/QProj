package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/2/5 15:48
 * Email : xiaokai090704@126.com
 * 使用自定义的标题拦
 */

public class QprojToolBar extends LinearLayout {


    private ImageView iv;
    private Context mContext;

    public QprojToolBar(Context context) {
        super(context);
        mContext = context;
        initViews();
    }

    public QprojToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initViews();
    }

    public QprojToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }


    private void initViews() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.toolbar_qproj, this);

        iv = (ImageView) findViewById(R.id.toolbar_iv);
    }


    public ImageView getIv() {
        return iv;
    }
}
