package com.aoben.qproj.net;

import com.aoben.qproj.model.BannerData;
import com.aoben.qproj.model.BaseData;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by kenway on 18/3/20 11:33
 * Email : xiaokai090704@126.com
 */

public interface QpApiService {


//    /**
//     * 获取广告轮播图
//     * @param map  a=api
//     *             method=customized.thread.design
//     *             moduleid=10
//     *             appid=9FprO7RiGjFknxPo,
//     *             random=ica3gjycxqy2
//     *             tick=1521600960
//     *             sign=NWNjMzY3MDY0ODQ2NmI4OTMyYWNhYzkyNDMyMjJkODg2ZmY3YWQwMw==
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("aCloud/index.php")
//    Call<BaseData<List<BannerBean>>> getBanners(@FieldMap Map<String, String> map);


    /**
     * 获取广告,使用RxJava
     *
     *   @FormUrlEncoded  现在不需要该参数 , 因为不需要发送数据
     * @param
     * @return
     */
    @Multipart
    @POST("Advert/All")
    Observable<BaseData<BannerData>> getBannersRx(@PartMap Map<String, RequestBody> requestBodyMap);

    /**
     * 获取银行产品和赎楼产品
     * @param
     * @return
     */
    @Multipart
    @POST("Product/All")
    Observable<BaseData<ProductData>> getProductAll(@PartMap Map<String, RequestBody> requestBodyMap);


    /**
     * 明星业务员数据接口
     * @return
     */
    @Multipart
    @POST("Product/Salesman")
    Observable<BaseData<List<SalerBean>>> getSalerAll(@PartMap Map<String, RequestBody> requestBodyMap);



    /**
     *搜索数据接口

     * @return
     */
    @Multipart
    @POST("Product/Search")
    Call<String> getSerachString(@PartMap Map<String, RequestBody> requestBodyMap);



    /**
     *感兴趣用户数据提交
     * @param
     * @return
     */
    @Multipart
    @POST("Customer/Save")
    Observable<BaseData<Object>> submitIntendedUsersBody(@PartMap Map<String, RequestBody> requestBodyMap);
}
