package com.aoben.qproj.util;

import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.model.SearchData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/30 15:41
 * Email : xiaokai090704@126.com
 */

public class DataUtil {

    private static final int SUCCESS_CODE = 0;
    private static final String BANKPRODUCT = "bankProduct";
    private static final String REDEMPTION = "redemption";
    private static final String SALESMAN = "salesman";

    /**
     * 获取搜索返回的对象,
     * <p>
     * 使用的时候需要判读是否为空
     *
     * @param searchStr
     * @return
     */

    public static SearchData getSearchData(String searchStr) {


        LogUtils.e("返回的搜索数据为====" + searchStr);
        SearchData data = new SearchData();
        JSONObject object;

        try {
            object = new JSONObject(searchStr);
            int code = object.getInt("code");
            if (code != SUCCESS_CODE) {
                return data;
            }

            JSONObject dataObj = object.optJSONObject("data");


            LogUtils.e("dataObj=="+dataObj.toString());
            //判断是否为空
            if (Util.isNull(dataObj)) {

                return data;
            }



            //银行产品






            if (dataObj.toString().contains(BANKPRODUCT)){
                JSONArray arrayBank = dataObj.getJSONArray(BANKPRODUCT);
                List<ProductBean> banks = JsonUtil.jsonToBeanArray(arrayBank.toString(), ProductBean.class);
                data.setBankProduct(banks);
            }

            if (dataObj.toString().contains(REDEMPTION)){
                JSONArray arrayRedem = dataObj.getJSONArray(REDEMPTION);
                List<ProductBean> redems = JsonUtil.jsonToBeanArray(arrayRedem.toString(), ProductBean.class);
                data.setRedemption(redems);
            }

            if (dataObj.toString().contains(SALESMAN)){
                JSONArray arraySalesman = dataObj.getJSONArray(SALESMAN);
                List<SalerBean> salers = JsonUtil.jsonToBeanArray(arraySalesman.toString(), SalerBean.class);
                data.setSalesman(salers);
            }


            LogUtils.e("data=="+data.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * 每次获取集合中的一部分数据
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> getShowData(List<T> list, int count) {
        List<T> listReturn = new ArrayList<>();

        if (Util.isNull(list) || list.size() == 0) {
            return listReturn;
        }

        if (list.size() < count) {
            listReturn.addAll(list);
            list.clear();
            return listReturn;
        }
        for (int i = 0; i < count;i++) {
            listReturn.add(list.get(i));
        }
        LogUtils.e("list.size="+list.size());
        LogUtils.e("listReturn.size="+listReturn.size());
        for (int i=0;i<listReturn.size();i++){
            list.remove(listReturn.get(i));
        }
        LogUtils.e("list.size="+list.size());
        return listReturn;

    }
}
