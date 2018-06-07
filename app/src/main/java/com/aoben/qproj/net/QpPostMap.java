package com.aoben.qproj.net;

import com.aoben.qproj.net.sha.SHA1;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.SystemUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenway on 18/3/21 14:16
 * Email : xiaokai090704@126.com
 * <p>
 * QpPostMap
 */

public class QpPostMap {


    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    private QpPostMap() {
    }

    private QpPostMap(Map<String, String> map) {
        this.map = map;
    }


    public static final class Builder {

        private static String KEY_PRODUCTID = "productId";
        private static String KEY_USERNAME = "username";
        private static String KEY_TELEPHONE = "telephone";
        private static String KEY_SEX = "sex";
        private static String KEY_SEARCH = "searchkey";


        private static String KEY_SIGNATURE = "signature";
        private static String KEY_NONCE = "nonce";
        private static String KEY_TIMESTAMP = "timestamp";


        public static String TOKEN = "TFAly3PoALdxuAtv";
        public static String NONCE = "AeQhkQfCQP";

        Map<String, String> buiderMap;


        public Builder() {
            buiderMap = new HashMap<>();

            long mills = SystemUtil.getCurrentTime();

            String base = mills + NONCE + TOKEN;

            String signature = SHA1.encode(base);

//            LogUtils.e("mills=="+mills);
//            LogUtils.e("base=="+base);
//            LogUtils.e("signature=="+signature);
            buiderMap.put(KEY_SIGNATURE, signature);
            buiderMap.put(KEY_NONCE, NONCE);
            buiderMap.put(KEY_TIMESTAMP, mills + "");

        }

        /**
         * 添加方法
         *
         * @param
         * @return
         */
        public Builder addProductID(String productid) {
            buiderMap.put(KEY_PRODUCTID, productid);
            return this;
        }

        public Builder addUsername(String username) {
            buiderMap.put(KEY_USERNAME, username);

            return this;
        }

        public Builder addTelephone(String telephone) {
            buiderMap.put(KEY_TELEPHONE, telephone);
            return this;
        }

        public Builder addSex(String sex) {
            buiderMap.put(KEY_SEX, sex);
            return this;
        }

        public Builder addSearchkey(String searchkey) {
            buiderMap.put(KEY_SEARCH, searchkey);
            return this;
        }

        public QpPostMap build() {

            return new QpPostMap(buiderMap);

        }


    }
}
