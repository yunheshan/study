package com.bcs.study.util;

import java.util.Collection;
import java.util.Map;

/**
 * @Author bcs
 * @Date 2022/12/9 15:49
 * @Version 1.0
 * @Desc
 */
public class ValidUtils {
    /**
     * 判断对象是否Empty(null或元素为0)<br>
     * 对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param obj 待检查对象
     * @return boolean 返回的布尔值
     */

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj == "") {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).length() == 0;
        } else if (obj instanceof Collection) {
            return ((Collection<?>) obj).size() == 0;
        } else if (obj instanceof Map) {
            return ((Map<?, ?>) obj).size() == 0;
        } else if (obj.getClass().isArray()) {
            return ((Object[]) obj).length == 0;
        }
        return false;
    }
}
