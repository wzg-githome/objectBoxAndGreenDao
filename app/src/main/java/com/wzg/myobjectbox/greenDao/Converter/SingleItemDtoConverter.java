package com.wzg.myobjectbox.greenDao.Converter;

import com.wzg.myobjectbox.greenDao.bean.ItemListDTO;
import com.wzg.myobjectbox.utils.GsonUtils;
import com.wzg.myobjectbox.utils.JsonUtil;

import org.greenrobot.greendao.converter.PropertyConverter;


/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/29/029 15:41
 * desc:
 * <p>
 * List<ItemDto>  ItemDtos
 *
 */
public class SingleItemDtoConverter implements PropertyConverter<ItemListDTO, String> {


    /**
     * 获取 转换为集合对象
     */
    @Override
    public ItemListDTO convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            return GsonUtils.fromJson(databaseValue,ItemListDTO.class);
        }
    }

    /**
     * 转换为String 存储到数据库
     */
    @Override
    public String convertToDatabaseValue(ItemListDTO entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            return GsonUtils.toJson(entityProperty);
        }
    }
}
