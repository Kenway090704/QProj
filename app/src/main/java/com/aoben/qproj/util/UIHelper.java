package com.aoben.qproj.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aoben.qproj.R;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpPostMap;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.widget.CustomDialog;
import com.aoben.qproj.widget.CustomRadioButton;

import java.lang.reflect.Field;
import java.util.Map;

import io.reactivex.annotations.NonNull;

/**
 * Created by kenway on 18/3/6 11:45
 * Email : xiaokai090704@126.com
 */

public class UIHelper {


    private static LinearLayout layout_del;
    private static Button btn;
    private static Dialog dialog;

    public static void showKonwDialog(final Context context, final int productId) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_konw, null);

        final CustomDialog builder = new CustomDialog(context, 0, 0, view, R.style.dialog);
        //设置对话框显示的View
        builder.show();
        layout_del = (LinearLayout) builder.findViewById(R.id.dialog_layout_del);
        final EditText et_name = (EditText) builder.findViewById(R.id.dialog_know_et_name);
        final EditText et_phone = (EditText) builder.findViewById(R.id.dialog_know_et_phone);
        final CustomRadioButton crb = (CustomRadioButton) builder.findViewById(R.id.dialog_know_crb);
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
                //上传数据
                 //判断是否为电话号码

                if (!Util.isNullOrBlank(et_name.getText().toString()) &&
                        !Util.isNullOrBlank(et_phone.getText().toString())) {
                    QpPostMap qpPostMap = new QpPostMap.Builder().addProductID(productId + "")
                            .addUsername(et_name.getText().toString())
                            .addTelephone(et_phone.getText().toString())
                            .addSex(crb.getCurrentIndex() + "").build();

                    QpRetrofitManager.getInstance().submitIntentUsersFormData(qpPostMap.getMap()).subscribe(new BaseObServer<Object>() {
                        @Override
                        public void onHandleSuccess(Object o) {
                            SwToast.show(context, "发送成功");
                            builder.dismiss();
                        }

                    });
                }


            }
        });
    }


}
