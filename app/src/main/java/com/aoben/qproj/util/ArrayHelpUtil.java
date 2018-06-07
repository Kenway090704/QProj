package com.aoben.qproj.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kenway on 18/4/12 13:47
 * Email : xiaokai090704@126.com
 */

public class ArrayHelpUtil {

    public static String getArraySort(List<String> list) {

        if (null == list || list.size() == 0) {
            return "";
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
