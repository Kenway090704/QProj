package com.aoben.qproj.net;

import com.aoben.qproj.ui.QProjApplication;
import com.aoben.qproj.util.LogUtils;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kenway on 18/3/20 11:50
 * Email : xiaokai090704@126.com
 */

public class QpRetrofitManager {


    private static QpRetrofitManager manager;


    private Gson gson;

    private Retrofit retrofit;

    File cacheFile = new File(QProjApplication.getContext().getCacheDir(), "cache");
    Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);//50Mb缓存大小

    public QpApiService mApiService;


    public static QpRetrofitManager getInstance() {
        if (manager == null) {
            manager = new QpRetrofitManager();
        }
        return manager;
    }

    private QpRetrofitManager() {


        //现在未添加InterCeptor
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(60l, TimeUnit.SECONDS)
                .readTimeout(60l, TimeUnit.SECONDS)
                .writeTimeout(60l, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(QpAddress.baseUrl)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
//          Caused by: java.lang.IllegalArgumentException: Could not locate call adapter for io.reactivex.Observable<com.aoben.qproj.model.BaseData<java.util.List<com.aoben.qproj.model.BannerBean>>>.
        //原因是忘记添加 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        //    compile 'com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0'
        mApiService = retrofit.create(QpApiService.class);


    }


    /**
     * 获取广告接口
     *
     * @param
     * @return
     */
    public Observable getBannersRx() {
        Map map = new QpPostMap.Builder().build().getMap();

        LogUtils.e("获取广告==="+map.toString());
        return mApiService.getBannersRx(generateRequestBody(map)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * 获取银行和赎楼产品
     *
     * @param
     * @return
     */
    public Observable getProductAll() {
        Map map = new QpPostMap.Builder().build().getMap();


//        LogUtils.e("获取产品列表=="+map.toString());
        return mApiService.getProductAll(generateRequestBody(new QpPostMap.Builder().build().getMap())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取明星业务员接口
     *
     * @return
     */
    public Observable getSalers() {
        Map map = new QpPostMap.Builder().build().getMap();

        return mApiService.getSalerAll(generateRequestBody(map)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * 搜索数据接口,返回数据json  字段
     *
     * @param keyword
     * @return
     */
    public void getSearchData(String keyword, Callback<String> callback) {


        Map map = new QpPostMap.Builder().addSearchkey(keyword).build().getMap();

        LogUtils.e("搜索map==" + map.toString());
        mApiService.getSerachString(generateRequestBody(map)).enqueue(callback);
    }


    /**
     * 感兴趣用户数据提交接口
     *
     * @param requestBodyMap
     * @return
     */
    public Observable submitIntentUsersFormData(Map<String, String> requestBodyMap) {
        return mApiService.submitIntendedUsersBody(generateRequestBody(requestBodyMap)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    private static Map<String, RequestBody> generateRequestBody(Map<String, String> requestDataMap) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : requestDataMap.keySet()) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),
                    requestDataMap.get(key) == null ? "" : requestDataMap.get(key));
            requestBodyMap.put(key, requestBody);
        }

        return requestBodyMap;
    }
}
