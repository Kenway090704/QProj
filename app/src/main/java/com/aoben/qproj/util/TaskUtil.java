package com.aoben.qproj.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.util.List;

/**
 * Created by kenway on 18/5/23 14:06
 * Email : xiaokai090704@126.com
 */

public class TaskUtil {


    /**
     * 判断某个activity是否存在于栈中
     */

    public static boolean idExsitActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        ComponentName cmpName = intent.resolveActivity(context.getPackageManager());
        boolean flag = false;
        if (cmpName != null) {
            ActivityManager am = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> taskInfos = am.getRunningTasks(10);
            for (ActivityManager.RunningTaskInfo taskInfo : taskInfos) {
                if (taskInfo.baseActivity.equals(cmpName)) {
                    flag = true;
                    break;//跳出循环,优化效率
                }

            }
        }
        return flag;

    }
}
