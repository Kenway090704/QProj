package com.aoben.qproj.net;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kenway on 18/3/21 17:24
 * Email : xiaokai090704@126.com
 *
 * 网络回调的接口
 * 
 * 暂未使用,先调试RxJava
 */

public abstract class NetCallBack<T> implements Callback<T> {
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        //统一处理回调错误的情况


    }
}
