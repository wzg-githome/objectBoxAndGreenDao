package com.wzg.myobjectbox.greenDao.bean;

import com.wzg.myobjectbox.greenDao.Converter.SingleItemDtoConverter;
import com.wzg.myobjectbox.greenDao.Converter.ItemDtoConverter;
import com.wzg.myobjectbox.greenDao.Converter.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;


/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/19/019 11:51
 * desc: 巡检汇报
 */

@Entity
public class InspectionReportRs  {


    @Id
    public long insId;

    private Integer id;
    private String schemeCode;
    @Unique//当做唯一方便查询
    private String managerName;

    private String createTime;



    /**
     *
     */
    @Convert(columnType = String.class, converter = ItemDtoConverter.class)
    private List<ItemListDTO> itemList;


    @Convert(columnType = String.class, converter = SingleItemDtoConverter.class)
    private ItemListDTO   item;

    /**
     *
     */
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> imgs;



    @Generated(hash = 1657125372)
    public InspectionReportRs(long insId, Integer id, String schemeCode, String managerName, String createTime,
            List<ItemListDTO> itemList, ItemListDTO item, List<String> imgs) {
        this.insId = insId;
        this.id = id;
        this.schemeCode = schemeCode;
        this.managerName = managerName;
        this.createTime = createTime;
        this.itemList = itemList;
        this.item = item;
        this.imgs = imgs;
    }

    @Generated(hash = 959011355)
    public InspectionReportRs() {
    }




    @Override
    public String toString() {
        return "InspectionReportRs{" +
                "insId=" + insId +
                ", id=" + id +
                ", schemeCode='" + schemeCode + '\'' +
                ", managerName='" + managerName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", itemList=" + itemList +
                ", item=" + item +
                ", imgs=" + imgs +
                '}';
    }

    public long getInsId() {
        return this.insId;
    }

    public void setInsId(long insId) {
        this.insId = insId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchemeCode() {
        return this.schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getManagerName() {
        return this.managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<ItemListDTO> getItemList() {
        return this.itemList;
    }

    public void setItemList(List<ItemListDTO> itemList) {
        this.itemList = itemList;
    }

    public ItemListDTO getItem() {
        return this.item;
    }

    public void setItem(ItemListDTO item) {
        this.item = item;
    }

    public List<String> getImgs() {
        return this.imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}

