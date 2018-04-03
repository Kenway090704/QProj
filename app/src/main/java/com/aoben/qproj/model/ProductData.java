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


    private List<BankProductBean> bankProduct;
    private List<BankProductBean> redemption;

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

    public List<BankProductBean> getBankProduct() {
        return bankProduct;
    }

    public void setBankProduct(List<BankProductBean> bankProduct) {
        this.bankProduct = bankProduct;
    }

    public List<BankProductBean> getRedemption() {
        return redemption;
    }

    public void setRedemption(List<BankProductBean> redemption) {
        this.redemption = redemption;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "bankProduct=" + bankProduct +
                ", redemption=" + redemption +
                '}';
    }

    public static class BankProductBean implements Serializable {
        private int id;
        private int type;
        private String title;
        private String monthrate;
        private String quota;
        private String limittypt;
        private String agelimit;
        private String applynum;
        private String lendday;
        private String levelstar;
        private String alsostyle;
        private String advantage;
        private String logo;
        private String showimg;
        private String condition;
        private String material;
        private String operate;
        private String addtm;

        @Override
        public String toString() {
            return "BankProductBean{" +
                    "id=" + id +
                    ", type=" + type +
                    ", title='" + title + '\'' +
                    ", monthrate='" + monthrate + '\'' +
                    ", quota='" + quota + '\'' +
                    ", limittypt='" + limittypt + '\'' +
                    ", agelimit='" + agelimit + '\'' +
                    ", applynum='" + applynum + '\'' +
                    ", lendday='" + lendday + '\'' +
                    ", levelstar='" + levelstar + '\'' +
                    ", alsostyle='" + alsostyle + '\'' +
                    ", advantage='" + advantage + '\'' +
                    ", logo='" + logo + '\'' +
                    ", showimg='" + showimg + '\'' +
                    ", condition='" + condition + '\'' +
                    ", material='" + material + '\'' +
                    ", operate='" + operate + '\'' +
                    ", addtm='" + addtm + '\'' +
                    '}';
        }

        public static BankProductBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), BankProductBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<BankProductBean> arrayBankProductBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<BankProductBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMonthrate() {
            return monthrate;
        }

        public void setMonthrate(String monthrate) {
            this.monthrate = monthrate;
        }

        public String getQuota() {
            return quota;
        }

        public void setQuota(String quota) {
            this.quota = quota;
        }

        public String getLimittypt() {
            return limittypt;
        }

        public void setLimittypt(String limittypt) {
            this.limittypt = limittypt;
        }

        public String getAgelimit() {
            return agelimit;
        }

        public void setAgelimit(String agelimit) {
            this.agelimit = agelimit;
        }

        public String getApplynum() {
            return applynum;
        }

        public void setApplynum(String applynum) {
            this.applynum = applynum;
        }

        public String getLendday() {
            return lendday;
        }

        public void setLendday(String lendday) {
            this.lendday = lendday;
        }

        public String getLevelstar() {
            return levelstar;
        }

        public void setLevelstar(String levelstar) {
            this.levelstar = levelstar;
        }

        public String getAlsostyle() {
            return alsostyle;
        }

        public void setAlsostyle(String alsostyle) {
            this.alsostyle = alsostyle;
        }

        public String getAdvantage() {
            return advantage;
        }

        public void setAdvantage(String advantage) {
            this.advantage = advantage;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getShowimg() {
            return showimg;
        }

        public void setShowimg(String showimg) {
            this.showimg = showimg;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getOperate() {
            return operate;
        }

        public void setOperate(String operate) {
            this.operate = operate;
        }

        public String getAddtm() {
            return addtm;
        }

        public void setAddtm(String addtm) {
            this.addtm = addtm;
        }
    }


}
