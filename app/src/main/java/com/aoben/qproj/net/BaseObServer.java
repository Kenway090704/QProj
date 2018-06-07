package com.aoben.qproj.net;

import android.widget.Toast;

import com.aoben.qproj.model.BaseData;
import com.aoben.qproj.ui.QProjApplication;
import com.aoben.qproj.util.LogUtils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by kenway on 18/3/21 16:52
 * Email : xiaokai090704@126.com
 *
 * 使用Rxjava
 */

public abstract class BaseObServer<T> implements Observer<BaseData<T>> {

    private Disposable mdisposable;

    private final  int SUCCESS_CODE=0;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mdisposable=d;
    }

    @Override
    public void onNext(@NonNull BaseData<T> value) {
        if (value.getCode()==SUCCESS_CODE){

            LogUtils.e("返回数据成功");
            T t=value.getData();

            onHandleSuccess(t);
        }else {

            onHandleError(value.getCode(),value.getData().toString());
        }

    }

    @Override
    public void onError(@NonNull Throwable e) {
        LogUtils.e("请求出错=="+e.toString());
    }

    @Override
    public void onComplete() {

    }


    public abstract void onHandleSuccess(T t);

    /**错误信息统一处理
     *
     * @param code
     * @param message
     */
    void onHandleError(int code, String message) {
        Toast.makeText(QProjApplication.getContext(), message, Toast.LENGTH_LONG).show();
    }

}
