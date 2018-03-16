package com.aoben.qproj.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.widget.CustomDialog;

import java.lang.reflect.Field;

/**
 * Created by kenway on 18/3/6 11:45
 * Email : xiaokai090704@126.com
 */

public class UIHelper {


    private static LinearLayout layout_del;
    private static Button btn;
    private static Dialog dialog;



    public static void showKonwDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_konw, null);

        final CustomDialog builder = new CustomDialog(context, 0, 0, view, R.style.dialog);
        //设置对话框显示的View
        builder.show();


        layout_del = (LinearLayout) builder.findViewById(R.id.dialog_layout_del);

        btn = (Button) builder.findViewById(R.id.dialog_konw_btn);

        layout_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (builder.isShowing()) {
                    builder.dismiss();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }




}
