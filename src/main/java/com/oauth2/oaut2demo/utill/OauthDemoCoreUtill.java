package com.oauth2.oaut2demo.utill;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OauthDemoCoreUtill {
    public static boolean isNull(String checkString) {
        if (null == checkString || checkString.trim().length() == 0 || checkString.trim().equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    public static boolean isValidObject(Object object) {
        if (null != object) {
            return true;
        }
        return false;
    }

    public static boolean isListEmpty(List<?> dataList) {
        if (null == dataList || dataList.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isMapEmpty(Map<?, ?> dataMap) {
        if (null == dataMap || dataMap.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isSetEmpty(Set<?> dataSet) {
        if (null == dataSet || dataSet.isEmpty()) {
            return true;
        }
        return false;
    }

    public static long convertDateToMilliSeconds(String myDate) {
        //= "2014/10/29 18:10:45";
        if (myDate != null) {
            Instant instant = Instant.parse(myDate);
            return instant.toEpochMilli();
        } else {
            return 0;
        }
    }
}
