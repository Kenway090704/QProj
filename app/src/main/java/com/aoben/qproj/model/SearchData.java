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
 * Created by kenway on 18/3/29 16:48
 * Email : xiaokai090704@126.com
 */

public class SearchData  implements Serializable{


    private List<ProductBean> bankProduct;
    private List<ProductBean> redemption;
    private List<SalerBean> salesman;

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

    public List<SalerBean> getSalesman() {
        return salesman;
    }

    public void setSalesman(List<SalerBean> salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "bankProduct=" + bankProduct +
                ", redemption=" + redemption +
                ", salesman=" + salesman +
                '}';
    }
}
