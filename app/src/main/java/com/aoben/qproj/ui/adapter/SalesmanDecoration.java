package com.aoben.qproj.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aoben.qproj.util.DisplayUtils;

/**
 * Created by kenway on 18/2/7 10:20
 * Email : xiaokai090704@126.com
 */

public class SalesmanDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SalesmanDecoration(int space) {

        this.space = space;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = DisplayUtils.dp2px(view.getContext(), 0);
        } else {
            outRect.top = DisplayUtils.dp2px(view.getContext(), 7);
        }
    }
}
