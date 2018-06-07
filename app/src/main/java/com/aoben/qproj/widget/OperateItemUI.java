package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;
import com.aoben.qproj.util.Util;

/**
 * Created by kenway on 18/3/6 15:03
 * Email : xiaokai090704@126.com
 */

public class OperateItemUI extends LinearLayout {

    private Context context;
    private ImageView iv;

    public OperateItemUI(Context context) {
        super(context);

        this.context = context;

        initViews();
    }


    public OperateItemUI(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        initViews();
    }

    public OperateItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.item_operate, this);

        iv = (ImageView) view.findViewById(R.id.operate_iv);
    }

    public  void  setIv(String url){

        if(!Util.isNullOrBlank(url)){
            ImageLoader.loadNoPlaceHolder(context,url,iv);
        }

    }

}
