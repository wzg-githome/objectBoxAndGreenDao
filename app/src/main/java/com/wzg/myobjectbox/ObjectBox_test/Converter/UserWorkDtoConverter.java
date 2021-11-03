package com.wzg.myobjectbox.ObjectBox_test.Converter;

import com.wzg.myobjectbox.ObjectBox_test.bean.UserWork;
import com.wzg.myobjectbox.utils.GsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.objectbox.converter.PropertyConverter;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/11/3/003 16:11
 * desc: todo...
 */
public class UserWorkDtoConverter implements PropertyConverter<List<UserWork>, String> {
    @Override
    public List<UserWork> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) return null;
        List<UserWork> list = new ArrayList<>();
        if (databaseValue.contains("&")) {
            List<String> itString = Arrays.asList(databaseValue.split("&"));

            if (itString.size() > 0) {
                for (String item : itString) {
                    list.add(GsonUtils.fromJson(item, UserWork.class));
                }

            }
        }
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<UserWork> entityProperty) {
        if (entityProperty == null) return null;

        StringBuilder builder = new StringBuilder();
        if (entityProperty.size() > 0) {
            for (UserWork item : entityProperty) {
                builder.append(GsonUtils.toJson(item))
                        .append("&");
            }
        }
        return builder.toString();
    }
}
