package com.aoben.qproj.net;

/**
 * Created by kenway on 18/3/20 11:57
 * Email : xiaokai090704@126.com
 */

public class QpAddress {
    public  static  String baseUrl;
    public  static void  setDebug(boolean isDebug){

        if (isDebug){
            baseUrl="http://m.wxts.cqjyck.com/Api/";
        }else {
            baseUrl="http://api.club.auldey.com/";
        }
    }
}
