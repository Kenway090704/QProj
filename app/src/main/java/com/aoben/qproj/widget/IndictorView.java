package com.aoben.qproj.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.util.DisplayUtils;
import com.aoben.qproj.util.LogUtils;

import java.util.List;

/**
 * Created by kenway on 18/3/16 13:59
 * Email : xiaokai090704@126.com
 * 自定义的指示器
 */

public class IndictorView extends LinearLayout {
    private Context context;
    private View view;
    private LinearLayout layout;

    //这些属性全部变为自定义属性

    private int count = 0;//指示器的数量
    private int selectIndicatorResid = R.drawable.ic_indicator_circle_s;//选中时候的图片
    private int noSelectIndicatorResid = R.drawable.ic_indicator_circle_n; //未选中的时候的图片

    private int inidicatorWidhtDp;//指示器的宽
    private int inidicatorWidhtDp_default = 7;        //指示器默认的宽 dp
    private int inidictorHeightDp;//指示器的高
    private int inidictorHeightDp_default = 7;//指示器默认的高 dp

    private int inidicatorMarginLeft; //指示器MarginLeft
    private int inidicatorMarginLeft_default = 3;

    private int  beforeSelectIndex=0;


    public IndictorView(Context context) {
        super(context, null);
        LogUtils.e("count=" + count);
        this.context = context;
    }

    public IndictorView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        this.context = context;

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.IndictorView);

        count = array.getInteger(count, R.styleable.IndictorView_indicator_count);
        selectIndicatorResid = array.getResourceId(R.styleable.IndictorView_indicator_s_resid, R.drawable.ic_indicator_circle_s);
        noSelectIndicatorResid = array.getResourceId(R.styleable.IndictorView_indicator_n_resid, R.drawable.ic_indicator_circle_n);
        inidicatorWidhtDp = array.getDimensionPixelSize(R.styleable.IndictorView_indicator_width, DisplayUtils.dp2px(context, inidicatorWidhtDp_default));
        inidictorHeightDp = array.getDimensionPixelSize(R.styleable.IndictorView_indicator_width, DisplayUtils.dp2px(context, inidictorHeightDp_default));
        inidicatorMarginLeft = array.getDimensionPixelOffset(R.styleable.IndictorView_indicator_margin_left, DisplayUtils.dp2px(context, inidicatorMarginLeft_default));
        array.recycle();



        //  默认的
        // count=0
        // selectIndicatorResid=2130837606
        // noSelectIndicatorResid=2130837605
        // inidicatorWidhtDp=7
        // inidictorHeightDp=7
        // inidicatorMarginLeft=3


        //count=4
        //selectIndicatorResid=2130837606
        //noSelectIndicatorResid=2130837605
        //inidicatorWidhtDp=21
        //inidictorHeightDp=21
        //inidicatorMarginLeft=9

        initViews();
    }

    public IndictorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

    }

    private void initViews() {
        view = LayoutInflater.from(context).inflate(R.layout.widget_indictor, this);
        layout = (LinearLayout) view.findViewById(R.id.widget_indicator_layout);
        if (count != 0) {
            setIndicatorsSize(count);
        }
    }


    public void setIndicatorsSize(int count) {
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(selectIndicatorResid);
            layout.addView(imageView);
            LinearLayout.LayoutParams params = (LayoutParams) imageView.getLayoutParams();
            params.height = inidicatorWidhtDp;
            params.width = inidictorHeightDp;
            //第一个不需要margin
            if (i != 0) {
                params.leftMargin = inidicatorMarginLeft;
                imageView.setImageResource(noSelectIndicatorResid);
            }
            imageView.setLayoutParams(params);
        }

    }

    /**
     * 设置选中的indicator
     *
     * @param index
     */
    public void setSelectIndex(int index) {


        ImageView imageViewbefore= (ImageView) layout.getChildAt(beforeSelectIndex);
        ImageView imageViewCureent= (ImageView)layout.getChildAt(index);

        if (null!=imageViewbefore)
        imageViewbefore.setImageResource(noSelectIndicatorResid);
        if (null!=imageViewCureent)
        imageViewCureent.setImageResource(selectIndicatorResid);

        beforeSelectIndex=index;
    }


}
