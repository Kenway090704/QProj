package com.aoben.qproj.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/29 16:48
 * Email : xiaokai090704@126.com
 */

public class SearchData {


    private List<ProductData.BankProductBean> bankProduct;
    private List<ProductData.BankProductBean> redemption;
    private List<SalerBean> salesman;

    public List<ProductData.BankProductBean> getBankProduct() {
        return bankProduct;
    }

    public void setBankProduct(List<ProductData.BankProductBean> bankProduct) {
        this.bankProduct = bankProduct;
    }

    public List<ProductData.BankProductBean> getRedemption() {
        return redemption;
    }

    public void setRedemption(List<ProductData.BankProductBean> redemption) {
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
