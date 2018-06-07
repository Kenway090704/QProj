package com.aoben.qproj.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/29 14:14
 * Email : xiaokai090704@126.com
 *
 * 获取银行产品和赎楼产品的data
 */

public class ProductData {


    private List<ProductBean> bankProduct;
    private List<ProductBean> redemption;

    public static ProductData objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), ProductData.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ProductData> arrayProductDataFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ProductData>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public List<ProductBean> getBankProduct() {
        return bankProduct;
    }

    public void setBankProduct(List<ProductBean> bankProduct) {
        this.bankProduct = bankProduct;
    }

    public List<ProductBean> getRedemption() {
        return redemption;
    }

    public void setRedemption(List<ProductBean> redemption) {
        this.redemption = redemption;
    }



    @Override
    public String toString() {
        return "ProductData{" +
                "bankProduct=" + bankProduct +
                ", redemption=" + redemption +
                '}';
    }
}
