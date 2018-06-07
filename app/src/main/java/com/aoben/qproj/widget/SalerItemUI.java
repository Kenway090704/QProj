package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.util.LogUtils;

/**
 * Created by kenway on 18/3/2 10:45
 * Email : xiaokai090704@126.com
 * <p>
 * 业务员UI
 */

public class SalerItemUI extends LinearLayout {
    private Context context;

    private LinearLayout layout_tool;

    private TextView tv_tool_name;
    private LinearLayout iv_more;

    private ImageView iv_photo;
    private TextView tv_name;
    private TextView tv_des;
    private TextView tv_introduce;


    public SalerItemUI(Context context) {
        super(context);

        this.context = context;
        initViews();
    }

    public SalerItemUI(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        initViews();
    }

    public SalerItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.item_salesman, this);
        layout_tool = (LinearLayout) view.findViewById(R.id.item_layout_tool);
        iv_more = (LinearLayout) view.findViewById(R.id.item_iv_more);
        tv_tool_name = (TextView) view.findViewById(R.id.item_tv_name);

        //

        iv_photo = (ImageView) view.findViewById(R.id.item_salerman_iv);
        tv_name = (TextView) view.findViewById(R.id.item_salerman_tv_name);
        tv_des = (TextView) view.findViewById(R.id.item_salerman_tv_des);
        tv_introduce = (TextView) view.findViewById(R.id.item_salerman_tv_introduce);


    }

    public void setLayoutTool(int isVisible, String name, OnClickListener listenerIvMore) {

        layout_tool.setVisibility(isVisible);
        tv_tool_name.setText(name);
        iv_more.setOnClickListener(listenerIvMore);


    }

    public void setData(SalerBean bean) {


        ImageLoader.loadNoPlaceHolder(context, bean.getAvatar(), iv_photo);
        tv_name.setText(bean.getName());
        tv_des.setText(bean.getSalerange());
        tv_introduce.setText(bean.getMark());


    }

}
