package com.example.pet.bean.util;

import org.springframework.beans.FatalBeanException;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ranjinghang@haier.com
 * @version V1.0.0
 * @date
 * @description 类注释
 * @Copyright www.haiermoney.comInc. All rights reserved.
 */
public class BeanUtil extends org.springframework.beans.BeanUtils {

    /**
     * List<Map<String, Object>> 转换为List<T>
     *
     * @param mapList
     * @param clazz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> List<T> toList(List<Map<String, Object>> mapList, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (mapList == null || clazz == null) {
            return null;
        }
        List<T> list = new ArrayList<>(mapList.size());
        for (Map<String, Object> map : mapList) {
            T t = clazz.newInstance();
            copyProperties(map, t);
            list.add(t);
        }
        return list;
    }

    /**
     * 从map中复制属性对对象
     *
     * @param map
     * @param target
     * @author bazhandao
     * @date 2018-11-10
     */
    public static void copyProperties(Map<String, Object> map, Object target) {
        if (map == null || target == null || map.isEmpty()) {
            return;
        }
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() == null) {
                continue;
            }
            try {
                String key = targetPd.getName();
                Object value = map.get(key);
                // 这里判断以下value是否为空
                setValue(target, targetPd, value);
            } catch (Exception ex) {
                throw new FatalBeanException("Could not copy properties from source to target", ex);
            }
        }
    }

    /**
     * 设置值到目标bean
     *
     * @param target
     * @param targetPd
     * @param value
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void setValue(Object target, PropertyDescriptor targetPd, Object value) throws IllegalAccessException, InvocationTargetException {
        // 这里判断以下value是否为空
        if (value != null) {
            Method writeMethod = targetPd.getWriteMethod();
            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                writeMethod.setAccessible(true);
            }
            writeMethod.invoke(target, value);
        }
    }
}
