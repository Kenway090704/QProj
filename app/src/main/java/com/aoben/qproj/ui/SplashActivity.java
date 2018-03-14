package com.aoben.qproj.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aoben.qproj.R;
import com.aoben.qproj.ui.fragment.HomeActivity;

/**
 * Created by kenway on 18/2/27 15:04
 * Email : xiaokai090704@126.com
 */

public class SplashActivity extends BaseActivity {

    private TextView time;
    private int currentTime = 3;

    private RelativeLayout rl;

    private boolean isJump=false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            currentTime--;
            time.setText( currentTime + "s");
            if (currentTime == 0) {
                //进入MainActivity

                if (!isJump)
                MainActivity.actionStartClearStack(SplashActivity.this);
//                HomeActivity.actionStart(SplashActivity.this);
            } else {
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        rl = (RelativeLayout) findViewById(R.id.acty_splash_rl);

        time = (TextView) findViewById(R.id.acty_splash_tv_time);
        time.setText("跳过3s");
        handler.sendEmptyMessage(0);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void initListener() {
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.actionStartClearStack(SplashActivity.this);

                isJump=true;
            }
        });
    }
}
