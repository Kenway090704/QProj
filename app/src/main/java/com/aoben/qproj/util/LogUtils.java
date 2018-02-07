package com.aoben.qproj.util;


import android.text.TextUtils;



/**
 *
 * @author AlbieLiang
 */
public class LogUtils {
    public static boolean isDebug = true;//默认是true,发布的时候要将其变为false
    public static boolean isUserOther = false;//默认是使用的自己的日志管理办法类,是否使用bpApp中的日志管理类
    public static final int VERBOSE = android.util.Log.VERBOSE;
    public static final int DEBUG = android.util.Log.DEBUG;
    public static final int INFO = android.util.Log.INFO;
    public static final int WARN = android.util.Log.WARN;
    public static final int ERROR = android.util.Log.ERROR;
    public static final int ASSERT = android.util.Log.ASSERT;


    //    输出什么级别的日志
    public static final int LEVEL = VERBOSE;

    public static final String SEPARATOR = ",";

    /**
     * 初始化log是否可以输出
     * @param isdebug debug--true  release--false
     */
    public  static  void  initLog(boolean isdebug){
        isDebug=isdebug;
    }




    /**
     * VERBOSE
     * LogUtils工具说明:
     * 1 只输出等级大于等于LEVEL的日志
     * 所以在开发和产品发布后通过修改LEVEL来选择性输出日志.
     * 当LEVEL=NOTHING则屏蔽了所有的日志.
     * 2 v,d,i,w,e均对应两个方法.
     * 若不设置TAG或者TAG为空则为设置默认TAG
     *
     * @param message
     */
    public static void v(String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= VERBOSE) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            android.util.Log.v(tag, getLogInfo(stackTraceElement) + message);


        }
    }

    public static void v(String tag, String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= VERBOSE) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            android.util.Log.v(tag, getLogInfo(stackTraceElement) + message);


        }
    }


    /**
     * Description
     *
     * @param message
     */

    public static void d(String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            android.util.Log.d(tag, getLogInfo(stackTraceElement) + message);


        }
    }

    public static void d(String tag, String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            android.util.Log.d(tag, getLogInfo(stackTraceElement) + message);

        }
    }

    /**
     * Info log
     *
     * @param format

     */

    public static void i(String tag, String format,Object...args) {

        if (!isDebug) return;
        if (LEVEL <= INFO) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            android.util.Log.i(tag, getLogInfo(stackTraceElement) + format);


        }


    }


    public static void i(String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= INFO) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            android.util.Log.i(tag, getLogInfo(stackTraceElement) + message);

        }

    }

    /**
     * Error
     *
     * @param tag
     * @param message
     */
    public static void e(String tag, String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= ERROR) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            android.util.Log.e(tag, getLogInfo(stackTraceElement) + message);

        }
    }

    public static void e(String message,Object...args) {

        if (!isDebug) return;
        if (LEVEL <= ERROR) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            android.util.Log.e(tag, getLogInfo(stackTraceElement) + message);

        }
    }

    /**
     * Warming
     *
     * @param message
     */

    public static void w(String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= WARN) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            android.util.Log.w(tag, getLogInfo(stackTraceElement) + message);

        }
    }

    public static void w(String tag, String message,Object...args) {
        if (!isDebug) return;
        if (LEVEL <= WARN) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(tag)) {
                tag = getDefaultTag(stackTraceElement);
            }
            android.util.Log.w(tag, getLogInfo(stackTraceElement) + message);

        }
    }

    /**
     * 获取默认的TAG名称.
     * 比如在MainActivity.java中调用了日志输出.
     * 则TAG为MainActivity
     */
    public static String getDefaultTag(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        String stringArray[] = fileName.split("\\.");
        String tag = stringArray[0];
        return tag;
    }

    /**
     * 输出日志所包含的信息
     */
    public static String getLogInfo(StackTraceElement stackTraceElement) {
        StringBuilder logInfoStringBuilder = new StringBuilder();
        // 获取线程名
//        String threadName = Thread.currentThread().getName();
//        // 获取线程ID
//        long threadID = Thread.currentThread().getId();
        // 获取文件名.即xxx.java
//        String fileName = stackTraceElement.getFileName();
        // 获取类名.即包名+类名
        String className = stackTraceElement.getClassName();
        // 获取方法名称
        String methodName = stackTraceElement.getMethodName();
        // 获取生日输出行数
        int lineNumber = stackTraceElement.getLineNumber();

        logInfoStringBuilder.append("[ ");
//        logInfoStringBuilder.append("threadID=" + threadID).append(SEPARATOR);
//        logInfoStringBuilder.append("threadName=" + threadName).append(SEPARATOR);
//        logInfoStringBuilder.append("fileName=" + fileName).append(SEPARATOR);
        logInfoStringBuilder.append("className=" + className).append(SEPARATOR);
        logInfoStringBuilder.append("methodName=" + methodName).append(SEPARATOR);
        logInfoStringBuilder.append("lineNumber=" + lineNumber);
        logInfoStringBuilder.append(" ] ");
        return logInfoStringBuilder.toString();
    }

}
