package com.aoben.qproj.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.aoben.qproj.R;
import com.aoben.qproj.util.DisplayUtils;

/**
 * Created by kenway on 18/3/7 15:29
 * Email : xiaokai090704@126.com
 */

public class CustomDialog extends Dialog {

    private static int default_width = 300;
    private static int default_height = 280;

    public CustomDialog(Context context, View layout, int style) {
        this(context, DisplayUtils.dp2px(context,default_width) ,DisplayUtils.dp2px(context,default_height) , layout, style);

    }

    public CustomDialog(Context context, int default_width, int default_height, View layout, int themeResId) {
        super(context, themeResId);

        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int displayWidth = dm.widthPixels;
        int displayHeight = dm.heightPixels;
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值
        p.width = (int) (displayWidth * 0.83);    //宽度设置为屏幕的0.9375   300/320
        p.height = (int) (displayHeight * 0.4375);    //高度设置为屏幕的0.28
        window.setAttributes(p);     //设置生效

    }


}
