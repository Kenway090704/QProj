package com.aoben.qproj.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aoben.qproj.R;
import com.aoben.qproj.util.KeyBoardUtils;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.NavEditText;
import com.aoben.qproj.widget.NavItemUI;
import com.aoben.qproj.widget.QprojToolBar;

/**
 * Created by kenway on 18/2/5 15:27
 * Email : x
 * <p>
 * iaokai090704@126.com
 */

public abstract class DrawerBaseActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {
    //为了使用svg
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private DrawerLayout drawerLayout;

    private LinearLayout contentView;
    private RelativeLayout drawer_layout;

    private QprojToolBar qprojToolBar;

    public NavEditText nav_et;

    private NavItemUI nav_01, nav_02, nav_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_base);

        // 将Activity  添加到集合中
        QProjApplication.getIns().add(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        drawerLayout = (DrawerLayout) findViewById(R.id.acty_drawer_layout);
        drawerLayout.addDrawerListener(this);
        contentView = (LinearLayout) findViewById(R.id.acty_base_content_layout);
        qprojToolBar = (QprojToolBar) findViewById(R.id.acty_base_qtoolbar);
        //侧滑栏
        drawer_layout = (RelativeLayout) findViewById(R.id.acty_base_drawer_layout);
        nav_et = (NavEditText) findViewById(R.id.nav_drawer_base_et);
        nav_01 = (NavItemUI) findViewById(R.id.nav_drawer_base_nav_01);
        nav_02 = (NavItemUI) findViewById(R.id.nav_drawer_base_nav_02);
        nav_03 = (NavItemUI) findViewById(R.id.nav_drawer_base_nav_03);

        //点击搜索按钮时显示的内容。
        nav_et.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                if (actionId== EditorInfo.IME_ACTION_SEARCH){

                }
                return false;
            }
        });

        initBaseEvent();
        View view = LayoutInflater.from(this).inflate(getLayoutId(), null);

        if (!Util.isNull(view))
            contentView.addView(view);


        initView();
        initData();
        initListener();


    }


    private void initBaseEvent() {
        //给标题栏右边的iv添加点击事件
        qprojToolBar.getIv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        qprojToolBar.getBackIv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nav_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                AllProductActivity.actionStart(v.getContext());


            }
        });

        nav_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入赎楼产品页
                drawerLayout.closeDrawer(GravityCompat.START);
                AllProductActivity.actionStart(v.getContext());
            }
        });

        nav_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                SalesmanActivity.actionStart(v.getContext());


            }
        });
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

    @Override
    public void onDrawerStateChanged(int newState) {

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


    /**
     * 获取QprojToolBar控件
     * @return
     */
    public  QprojToolBar getToolBar(){
        return qprojToolBar;
    }


    //DrawerLayout的监听事件
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        //侧滑栏打开的时候,侧滑栏拦截事件
        drawer_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    @Override
    public void onDrawerClosed(View drawerView) {

        //侧滑栏关闭的时候,不拦截事件
        drawer_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        //关闭输入键盘。让底下的控件获取焦点
        KeyBoardUtils.closeKeybord(nav_et.getEditText(), DrawerBaseActivity.this);
    }


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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
