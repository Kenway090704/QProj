package com.aoben.qproj.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/29 12:11
 * Email : xiaokai090704@126.com
 */

public class BannerData {


    private List<StartBean> start;
    private List<StartBean> index;

    public static BannerData objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), BannerData.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<BannerData> arrayBannerDataFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<BannerData>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getJSONArray(key).toString(), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public List<StartBean> getStart() {
        return start;
    }

    public void setStart(List<StartBean> start) {
        this.start = start;
    }

    public List<StartBean> getIndex() {
        return index;
    }

    public void setIndex(List<StartBean> index) {
        this.index = index;
    }

    public static class StartBean {
        private int id;
        private String title;
        private int type;
        private String imgsrc;
        private String weburl;
        private int staytime;

        @Override
        public String toString() {
            return "StartBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", weburl='" + weburl + '\'' +
                    ", staytime=" + staytime +
                    '}';
        }

        public static StartBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getJSONObject(key).toString(), StartBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<StartBean> arrayStartBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<StartBean>>() {
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public int getStaytime() {
            return staytime;
        }

        public void setStaytime(int staytime) {
            this.staytime = staytime;
        }
    }

    @Override
    public String toString() {
        return "BannerData{" +
                "start=" + start +
                ", index=" + index +
                '}';
    }
}
