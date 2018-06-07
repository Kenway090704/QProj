package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/5/10 11:32
 * Email : xiaokai090704@126.com
 */

public class SearchHintUI extends LinearLayout {


    private Context mContext;

    public SearchHintUI(Context context) {
        this(context, null);
    }

    public SearchHintUI(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchHintUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;

        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.search_hint,this);


    }
}
