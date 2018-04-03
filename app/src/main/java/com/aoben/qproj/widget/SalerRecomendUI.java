package com.aoben.qproj.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aoben.qproj.R;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.ui.SalesmanActivity;
import com.aoben.qproj.util.ResourceUtil;

import java.util.List;

/**
 * Created by kenway on 18/3/5 13:57
 * Email : xiaokai090704@126.com
 */

public class SalerRecomendUI extends LinearLayout {

    private Context context;

    private SalerItemUI siu01, siu02, siu03;

    public SalerRecomendUI(Context context) {
        super(context);
        this.context = context;
        initViews();
    }


    public SalerRecomendUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public SalerRecomendUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {
        View view = LayoutInflater.from(context).inflate(R.layout.widget_saler, this);


        siu01 = (SalerItemUI) view.findViewById(R.id.widget_saler_siu_01);
        siu02 = (SalerItemUI) view.findViewById(R.id.widget_saler_siu_02);
        siu03 = (SalerItemUI) view.findViewById(R.id.widget_saler_siu_03);

        siu01.setLayoutTool(View.VISIBLE, ResourceUtil.resToStr(R.string.excellent_saler), new OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入业务员页面
                SalesmanActivity.actionStart(context);
            }
        });


    }

    public  void setData(List<SalerBean> list){

        siu01.setData(list.get(0));
        siu02.setData(list.get(1));
        siu03.setData(list.get(2));

    }
}
