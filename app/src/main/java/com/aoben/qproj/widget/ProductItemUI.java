package com.aoben.qproj.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;

/**
 * Created by kenway on 18/2/28 15:17
 * Email : xiaokai090704@126.com
 * <p>
 * 产品UI
 */

public class ProductItemUI extends LinearLayout {
    private Context context;

    private LinearLayout layout_tool;

    private TextView tv_tool_name;
    private LinearLayout iv_more;

    private ImageView iv_logo;
    private TextView tv_name, tv_rate, tv_limit, tv_year, tv_person_num, tv_time, tv_pay_style, tv_advantage;

    private CirclePercentBar circlePercentBar;

    private StarUI star;

    public ProductItemUI(Context context) {
        super(context);
        this.context = context;
        initViews();
    }


    public ProductItemUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public ProductItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_allp, this);
        layout_tool = (LinearLayout) view.findViewById(R.id.item_layout_tool);
        iv_more = (LinearLayout) view.findViewById(R.id.item_iv_more);
        tv_tool_name = (TextView) view.findViewById(R.id.item_tv_name);

        tv_name = (TextView) view.findViewById(R.id.item_allp_tv_name);
        iv_logo = (ImageView) view.findViewById(R.id.item_allp_iv_logo);
        tv_rate = (TextView) view.findViewById(R.id.item_allp_tv_rate);
        tv_limit = (TextView) view.findViewById(R.id.item_allp_tv_limit);
        tv_year = (TextView) view.findViewById(R.id.item_allp_tv_year);
        tv_person_num = (TextView) view.findViewById(R.id.item_allp_tv_person_num);
        tv_time = (TextView) view.findViewById(R.id.item_allp_tv_time);
        circlePercentBar = (CirclePercentBar) view.findViewById(R.id.item_allp_circle_bar);
        tv_pay_style = (TextView) view.findViewById(R.id.item_allp_tv_pay_style);
        tv_advantage = (TextView) view.findViewById(R.id.item_allp_tv_advantage);
        star = (StarUI) view.findViewById(R.id.item_allp_star);
    }


    public void setData(ProductData.BankProductBean bean) {


        tv_name.setText(bean.getTitle());
        setTextColor(tv_rate, bean.getMonthrate() + "%", "%", "#666666", 0.494f);
        ImageLoader.load(context, bean.getShowimg(), iv_logo);
        int quota = Integer.parseInt(bean.getQuota()) / 10000;
        setTextColor(tv_limit, quota + "万", "万", "#666666", 0.65f);
        setTextColor(tv_year, bean.getAgelimit() + "年", "年", "#666666", 0.65f);
        setTextColor(tv_person_num, "已有" + bean.getApplynum() + "人申请", bean.getApplynum(), "#ff9600");
        setTextColor(tv_time, "最快" + bean.getLendday() + "天放款", bean.getLendday(), "#ff9600");


        circlePercentBar.setPercentData((float) (100 * Math.random()), new DecelerateInterpolator());

        tv_pay_style.setText(bean.getAlsostyle());
        tv_advantage.setText(bean.getAdvantage());

        star.setStarCount(bean.getLevelstar());
//        star.setStarCount("2");
    }


    public void setLayoutTool(int isVisible, String name, OnClickListener listenerIvMore) {

        layout_tool.setVisibility(isVisible);
        tv_tool_name.setText(name);

        if (!Util.isNull(listenerIvMore))
            iv_more.setOnClickListener(listenerIvMore);


    }


    /**
     * 只改变字体颜色
     *
     * @param tv
     * @param base   原字符串
     * @param change "%"  改变样式的字符串
     * @param color  "#0099EE"
     */
    private void setTextColor(TextView tv, String base, String change, String color) {

        int index = base.indexOf(change);
        if (index == -1) return;


        SpannableString spannableString = new SpannableString(base);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor(color));
        spannableString.setSpan(colorSpan, index, index + change.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        tv.setText(spannableString);


    }

    /**
     * 改变字体颜色和大小
     *
     * @param tv
     * @param base   原字符串
     * @param change "%"  改变样式的字符串
     * @param color  "#0099EE"
     * @param size   0.394
     */
    private void setTextColor(TextView tv, String base, String change, String color, float size) {

        int index = base.indexOf(change);
        if (index == -1) return;


        SpannableString spannableString = new SpannableString(base);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor(color));
        spannableString.setSpan(colorSpan, index, index + change.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        //设置大小 0.65   0.394
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(size);
        spannableString.setSpan(sizeSpan01, index, index + change.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        tv.setText(spannableString);


    }

}
