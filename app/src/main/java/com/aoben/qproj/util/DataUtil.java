package com.aoben.qproj.util;

import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.model.SearchData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by kenway on 18/3/30 15:41
 * Email : xiaokai090704@126.com
 */

public class DataUtil {

    private static  final  int SUCCESS_CODE=0;
    /**
     * 获取搜索返回的对象,
     *
     * 使用的时候需要判读是否为空
     *
     * @param searchStr
     * @return
     */

    public static SearchData getSearchData(String searchStr) {

        SearchData data = new SearchData();
        JSONObject object;

        try {
            object = new JSONObject(searchStr);
            int code = object.getInt("code");
            if (code!=SUCCESS_CODE){
                return data;
            }

            JSONObject dataObj = object.optJSONObject("data");

            //银行产品
            JSONArray arrayBank = dataObj.optJSONArray("bankProduct");
            JSONArray arrayRedem = dataObj.optJSONArray("redemption");
            JSONArray arraySalesman = dataObj.optJSONArray("salesman");

            List<ProductData.BankProductBean> banks = JsonUtil.jsonToBeanArray(arrayBank.toString(), ProductData.BankProductBean.class);
            List<ProductData.BankProductBean> redems = JsonUtil.jsonToBeanArray(arrayRedem.toString(), ProductData.BankProductBean.class);
            List<SalerBean> salers = JsonUtil.jsonToBeanArray(arraySalesman.toString(), SalerBean.class);


            data.setBankProduct(banks);
            data.setRedemption(redems);
            data.setSalesman(salers);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
