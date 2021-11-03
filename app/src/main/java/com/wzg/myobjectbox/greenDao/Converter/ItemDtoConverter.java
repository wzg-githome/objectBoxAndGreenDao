package com.wzg.myobjectbox.greenDao.Converter;

import com.google.gson.reflect.TypeToken;
import com.wzg.myobjectbox.greenDao.bean.ItemListDTO;
import com.wzg.myobjectbox.utils.GsonUtils;
import com.wzg.myobjectbox.utils.JsonUtil;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/29/029 15:41
 * desc: 万能转换类
 * <p>
 * List<String>  imgs
 */
public class ItemDtoConverter implements PropertyConverter<List<ItemListDTO>, String> {


    /**
     * 获取 转换为集合对象
     */
    @Override
    public List<ItemListDTO> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            List<ItemListDTO> datas = new ArrayList<>();
            try {
                if (databaseValue.contains("&")) {
                    String[] list = databaseValue.split("&");
                    for (String item : list) {
                        datas.add(GsonUtils.fromJson(item, ItemListDTO.class));
                    }
                }
            } catch (Throwable e) {
                throw new RuntimeException("ListItemDtoConverter 转换异常");
            }
            return datas;
        }
    }

    /**
     * 转换为String 存储到数据库
     */
    @Override
    public String convertToDatabaseValue(List<ItemListDTO> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            StringBuilder builder = new StringBuilder();
            for (ItemListDTO item : entityProperty) {
                builder.append(GsonUtils.toJson(item))
                        .append("&");
            }
            return builder.toString();
        }
    }
}
