package com.aoben.qproj.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aoben.qproj.R;

/**
 * Created by kenway on 18/3/6 11:45
 * Email : xiaokai090704@126.com
 */

public class UIHelper {


    /**
     * 弹出提示框
     *
     * @param context
     */
    public static void showDialog(Context context) {

        final AlertDialog dialog = new AlertDialog.Builder(context).create();

        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_konw, null);
        dialog.setView(view);
        dialog.show();


        LinearLayout layout_del = (LinearLayout) view.findViewById(R.id.dialog_layout_del);

        Button btn = (Button) view.findViewById(R.id.dialog_konw_btn);


        layout_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
