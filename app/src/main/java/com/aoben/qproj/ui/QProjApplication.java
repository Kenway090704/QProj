package com.aoben.qproj.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/2/5 15:34
 * Email : xiaokai090704@126.com
 */

public class QProjApplication extends Application {

    private static Context mContext;

    private static QProjApplication ins;
    public static final boolean isDebug = true;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        setIns();
    }

    /**
     * 获取application的上下文对象
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }


    public static QProjApplication getIns() {
        return ins;
    }
    /**
     * 进行商品兑换时,点击,我知道了,回到goods_list 主页
     */
    /**
     * set Application instance
     */
    private void setIns() {
        ins = this;
    }


    //*************************当app发生崩溃时,重启app的启动页********************//
    private List<Activity> activityList = new ArrayList<Activity>();

    public void remove(Activity activity) {
        activityList.remove(activity);
    }

    public void add(Activity activity) {
        activityList.add(activity);
    }

    public void finishProgram() {
        for (Activity activity : activityList) {
            if (null != activity) {
                activity.finish();
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid());
    }


}
