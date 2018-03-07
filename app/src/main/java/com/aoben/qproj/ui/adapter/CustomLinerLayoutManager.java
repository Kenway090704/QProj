package com.aoben.qproj.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by kenway on 18/2/28 17:51
 * Email : xiaokai090704@126.com
 */

public class CustomLinerLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomLinerLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean scrollEnabled) {
        isScrollEnabled = scrollEnabled;
    }


    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
