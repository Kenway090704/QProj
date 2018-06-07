package com.aoben.qproj.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;
import com.aoben.qproj.model.BannerData;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;

/**
 * Created by kenway on 18/2/27 15:04
 * Email : xiaokai090704@126.com
 */

public class SplashActivity extends BaseActivity {

    private TextView time;
    private int currentTime = 4;

    private RelativeLayout rl_default;
    private RelativeLayout rl;
    private ImageView iv;

    private boolean isJump = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            currentTime--;
            time.setText(currentTime + "s");
            if (currentTime == 0) {
                //进入MainActivity
                if (!isJump)
                    MainActivity.actionStartClearStack(SplashActivity.this);
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
        rl_default = (RelativeLayout) findViewById(R.id.acty_splash_rl_default);
        rl = (RelativeLayout) findViewById(R.id.acty_splash_rl);
        iv = (ImageView) findViewById(R.id.acty_splash_iv);
        time = (TextView) findViewById(R.id.acty_splash_tv_time);
        time.setText("3s");
        handler.sendEmptyMessage(0);
    }
    @Override
    public void initData() {
        QpRetrofitManager.getInstance().getBannersRx().subscribe(new BaseObServer<BannerData>() {

            @Override
            public void onHandleSuccess(BannerData bannerData) {
                if (Util.isNull(bannerData) || Util.isNull(bannerData.getStart()) || bannerData.getStart().size() == 0) {
                    //判断返回的数据是否为空
                    rl_default.setVisibility(View.VISIBLE);
                } else {
                    ImageLoader.load(SplashActivity.this, bannerData.getStart().get(0).getImgsrc(), iv);
                }
            }
        });
    }

    @Override
    protected void initListener() {
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.actionStartClearStack(SplashActivity.this);
                isJump = true;
            }
        });
    }
}
