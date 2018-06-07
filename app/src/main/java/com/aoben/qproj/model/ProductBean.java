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
 * Created by kenway on 18/5/21 12:09
 * Email : xiaokai090704@126.com
 */

public class ProductBean implements Serializable {


    private String id;
    private String type;
    private String title;
    private String top;
    private String sort;
    private String status;
    private String monthrate;
    private String quota;
    private String limittype;
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

    public static ProductBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), ProductBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ProductBean> arrayProductBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ProductBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLimittype() {
        return limittype;
    }

    public void setLimittype(String limittype) {
        this.limittype = limittype;
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
