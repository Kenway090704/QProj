package com.aoben.qproj.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 打开或关闭软键盘
 *
 * @author zhy
 */
public class KeyBoardUtils {

    private static final String SHARE_PREFERENCE_NAME = "EmotionKeyboard";
    private static final String SHARE_PREFERENCE_SOFT_INPUT_HEIGHT = "soft_input_height";
    private SharedPreferences sp;

    /**
     * 打开软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mEditText.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }


    /**
     * 让指定的EditText获取焦点,并使光标最后一个文字后面
     */

    public static void setFoucus(EditText mEditText) {
        mEditText.setFocusable(true);
        mEditText.setFocusableInTouchMode(true);
        mEditText.requestFocus();
        mEditText.setSelection(mEditText.getText().length());
        //暂时不用打开键盘
        //KeyBoardUtils.openKeybord(mEditText, context);
    }

/*

 */

    /**
     * 获取键盘高度   在activity中使用,KeyboardUtils.addOnSoftKeyBoardVisibleListener(activity,listener);
     * 在listener中就可以获取到键盘的高度,和是否可见
     */
    public interface IKeyBoardVisibleListener {
        void onSoftKeyBoardVisible(boolean visible, int keyboardHeight);
    }

    public static void addOnSoftKeyBoardVisibleListener(final Activity activity, final IKeyBoardVisibleListener listener) {
        final View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                Rect r = new Rect();
                /**
                 * decorView是window中的最顶层view，可以从window中通过getDecorView获取到decorView。
                 * 通过decorView获取到程序显示的区域，包括标题栏，但不包括状态栏。
                 */
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                //获取屏幕的高度
                int screenHeight = activity.getWindow().getDecorView().getRootView().getHeight();
                //计算软件盘的高度

                int softInputHeight = screenHeight - r.bottom;

                /**
                 * 某些Android版本下，没有显示软键盘时减出来的高度总是144，而不是零，
                 * 这是因为高度是包括了虚拟按键栏的(例如华为系列)，所以在API Level高于20时，
                 * 我们需要减去底部虚拟按键栏的高度（如果有的话）
                 */
                if (Build.VERSION.SDK_INT >= 20) {
                    // When SDK Level >= 20 (Android L), the softInputHeight will contain the height of softButtonsBar (if has)
                    softInputHeight = softInputHeight - getSoftButtonsBarHeight(activity);
                }

                if (softInputHeight < 0) {
                    LogUtils.w("EmotionKeyboard--Warning: value of softInputHeight is below zero!");
                    listener.onSoftKeyBoardVisible(false, 0);
                }
                //存一份到本地
                if (softInputHeight > 0) {
                    SharedPreferences sp = activity.getSharedPreferences(SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
                    sp.edit().putInt(SHARE_PREFERENCE_SOFT_INPUT_HEIGHT, softInputHeight).apply();
                    if (!Util.isNull(listener))
                        listener.onSoftKeyBoardVisible(true, softInputHeight);
                }
            }
        });
    }

    /**
     * 底部虚拟按键栏的高度
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static int getSoftButtonsBarHeight(Activity mActivity) {
        DisplayMetrics metrics = new DisplayMetrics();
        //这个方法获取可能不是真实屏幕的高度
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;
        //获取当前屏幕的真实高度
        mActivity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        int realHeight = metrics.heightPixels;

        if (realHeight > usableHeight) {
            return realHeight - usableHeight;
        } else {
            return 0;
        }
    }


    /**
     * 将键盘的高度存储在sharedPreference
     *
     * @param context
     * @param keyBoardHeight
     */
    public static void setKeyboardHeight(Context context, int keyBoardHeight) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(SHARE_PREFERENCE_SOFT_INPUT_HEIGHT, keyBoardHeight).apply();
    }

    /***
     * 如果本地没有存储,默认是787
     *
     * @param context
     * @return
     */
    public static int getKeyboardHeight(Context context) {

        SharedPreferences sp = context.getSharedPreferences(SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
        int softInputHeight = sp.getInt(SHARE_PREFERENCE_SOFT_INPUT_HEIGHT, 787);
        return softInputHeight;
    }


}