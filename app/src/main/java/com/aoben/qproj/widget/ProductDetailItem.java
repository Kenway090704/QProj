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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.ProductDetailBean;
import com.aoben.qproj.util.UIHelper;

/**
 * Created by kenway on 18/3/6 11:20
 * Email : xiaokai090704@126.com
 */

public class ProductDetailItem extends LinearLayout {


    private Context context;

    private ImageView iv;
    private TextView tv_name, tv_advantage, tv_interest, tv_limit, tv_year, tv_alsostyle, tv_condition, tv_material;


    private Button btn;

    private  OperateItemUI operate;

    public ProductDetailItem(Context context) {
        super(context);

        this.context = context;
        initViews();
    }

    public ProductDetailItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public ProductDetailItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.widget_pro_detail, this);

        iv = (ImageView) view.findViewById(R.id.widget_pro_detail_iv);
        tv_name = (TextView) view.findViewById(R.id.widget_pro_detail_tv_name);
        tv_advantage = (TextView) view.findViewById(R.id.widget_pro_detail_tv_advantage);

        tv_interest = (TextView) findViewById(R.id.widget_pro_detail_tv_interst);
        tv_limit = (TextView) findViewById(R.id.widget_pro_detail_tv_limit);
        tv_year = (TextView) findViewById(R.id.widget_pro_detail_tv_year);
        tv_alsostyle = (TextView) view.findViewById(R.id.widget_pro_detail_tv_alsostyle);

        btn = (Button) view.findViewById(R.id.widget_pro_detail_btn);
        tv_condition = (TextView) view.findViewById(R.id.widget_pro_detail_tv_condition);
        tv_material = (TextView) view.findViewById(R.id.widget_pro_detail_tv_material);
      operate= (OperateItemUI) view.findViewById(R.id.widget_pro_detail_operate);

    }

    public void setData(final ProductBean bean) {

        ImageLoader.load(context, bean.getLogo(), iv);
        tv_name.setText(bean.getTitle());
        tv_advantage.setText(bean.getAdvantage());
        setTextColor(tv_interest, bean.getMonthrate() + "%", "%", 0.435f);

        int quota = Integer.parseInt(bean.getQuota());
        setTextColor(tv_limit, quota / 1000 + "万", "万", 0.435f);
        setTextColor(tv_year, bean.getAgelimit() + "年", "年", 0.435f);
        tv_alsostyle.setText(bean.getAlsostyle());
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showKonwDialog(context, Integer.parseInt(bean.getId()));
            }
        });
        tv_condition.setText(bean.getCondition());
        tv_material.setText(bean.getMaterial());
        operate.setIv(bean.getOperate());

    }


    /**
     * 改变字体颜色和大小
     *
     * @param tv
     * @param base   原字符串
     * @param change "%"  改变样式的字符串
     * @param size   33/13= 0.394  20/13= 0.65   23/10=0.435
     */
    private void setTextColor(TextView tv, String base, String change, float size) {

        int index = base.indexOf(change);
        if (index == -1) return;


        SpannableString spannableString = new SpannableString(base);

        //设置大小 0.65   0.394
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(size);
        spannableString.setSpan(sizeSpan01, index, index + change.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        tv.setText(spannableString);


    }


}
