package com.bcs.study.util;

import org.springframework.beans.BeanUtils;

/**
 * @Author bcs
 * @Date 2022/12/15 10:15
 * @Version 1.0
 * @Desc
 */
public class PackedBeanUtils {

    /**
     * 封装BeanUtils
     *
     * @param source 提供属性的对象
     * @param target 需要接收属性的对象
     */
    public static void copy2Object(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 根据来源对象属性赋值给提供的类型
     * @param source 提供属性的对象
     * @param target 需要接收属性的类对象
     * @param <T>  类型
     * @return
     */
    public static <T> T copy2Class(Object source, Class<T> target) {
        if (source == null || target == null) {
            return null;
        }
        try {
            T instance = target.getConstructor().newInstance();
            BeanUtils.copyProperties(source, instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
