package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/3/6 17:53
 * Email : xiaokai090704@126.com
 */

public class CustomRadioButton extends LinearLayout {

    private Context context;

    private LinearLayout layout_01, layout_02;
    private ImageView iv_01, iv_02;

    int currentIndex = 1;

    int changeIndex=1;

    public CustomRadioButton(Context context) {
        super(context);

        this.context = context;
        initViews();
    }


    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        initViews();
    }


    private void initViews() {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_radiobuttom, this);

        layout_01 = (LinearLayout) view.findViewById(R.id.custom_radiobutton_1);
        layout_02 = (LinearLayout) view.findViewById(R.id.custom_radiobutton_2);
        iv_01 = (ImageView) view.findViewById(R.id.custom_radiobuttom_iv_1);
        iv_02 = (ImageView) view.findViewById(R.id.custom_radiobuttom_iv_2);


        layout_01.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeIndex=1;
                if (currentIndex == 2) {
                    iv_01.setImageResource(R.drawable.ic_pop_checkbox_s);
                    iv_02.setImageResource(R.drawable.ic_pop_checkbox_n);
                }
                currentIndex=changeIndex;
            }
        });


        layout_02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeIndex=2;
                if (currentIndex == 1) {
                    iv_01.setImageResource(R.drawable.ic_pop_checkbox_n);
                    iv_02.setImageResource(R.drawable.ic_pop_checkbox_s);
                }
                currentIndex=changeIndex;
            }
        });


    }


    public int getCurrentIndex() {
        return currentIndex;
    }
}
