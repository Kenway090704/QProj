package com.aoben.qproj.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.util.LogUtils;

/**
 * Created by kenway on 18/2/5 15:27
 * Email : x
 *
 * iaokai090704@126.com
 */

public abstract class BaseActivity extends AppCompatActivity {
    //为了使用svg
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    private LinearLayout  contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        // 将Activity  添加到集合中
        QProjApplication.getIns().add(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
        initData();
        initListener();



    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //友盟统计

    }

    @Override
    protected void onPause() {
        super.onPause();
        //友盟统计

    }

    /**
     * @return the layout resource id
     */
    protected abstract int getLayoutId();

    /**
     * init the view.
     */
    protected abstract void initView();

    public abstract void initData();

    /**
     * register the listener to the view.
     */
    protected abstract void initListener();

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        LogUtils.e("onTrimMemory invoked the level is", level);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        QProjApplication.getIns().remove(this);
    }


}
