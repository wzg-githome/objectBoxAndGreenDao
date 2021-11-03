package com.wzg.myobjectbox.ObjectBox_test.Converter;

import java.util.Arrays;
import java.util.List;

import io.objectbox.converter.PropertyConverter;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/11/3/003 16:01
 * desc: String 集合转换类
 */
public class StringConverter implements PropertyConverter<List<String>, String> {
    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        List<String> strings = null;
        if (databaseValue.contains("&")) {
            strings = Arrays.asList(databaseValue.split("&"));
        }
        return strings;
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (String item : entityProperty) {
            builder.append(item)
                    .append("&");
        }
        return builder.toString();
    }
}
