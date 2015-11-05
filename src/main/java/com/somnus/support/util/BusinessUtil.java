package com.somnus.support.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.somnus.support.constant.Constants;

/**
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月5日 上午11:42:58
 * @version V1.0
 */
public class BusinessUtil {
    /**
     * 得到页面选中的数据
     * */
    public static LinkedHashMap<String, String> getStorage(String _storage) {
        Map<String, ArrayList<LinkedHashMap<String, String>>> map = JsonUtils.jsonString2Map(_storage);
        if (map == null || map.isEmpty())
            return null;
        ArrayList<LinkedHashMap<String, String>> ids = map.get(Constants._storage);
        if (ids == null || ids.isEmpty())
            return null;
        LinkedHashMap<String, String> selectArr = ids.get(0);
        if (selectArr == null || selectArr.isEmpty())
            return null;
        return selectArr;
    }

}
