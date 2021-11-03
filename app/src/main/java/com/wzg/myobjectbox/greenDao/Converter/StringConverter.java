package com.wzg.myobjectbox.greenDao.Converter;

import com.wzg.myobjectbox.utils.GsonUtils;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/29/029 15:41
 * desc: 将List<String> 转换为 String
 *
 *   List<String>  imgs
 */


public class StringConverter implements PropertyConverter<List<String>, String> {



    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (databaseValue != null) {
            if (databaseValue.contains(",")) {
                return Arrays.asList(databaseValue.split(","));
            }
        }
        return null;
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String entity : entityProperty) {
                sb.append(entity);
                sb.append(",");
            }
            return sb.toString();
        }
    }
}
