package com.wzg.myobjectbox.greenDao.bean;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/29/029 15:59
 * desc: todo...
 */

public class ItemListDTO {

    private Integer id;
    private String itemCode;
    private String itemName;


    public ItemListDTO() {
    }

    public ItemListDTO(Integer id, String itemCode, String itemName) {
        this.id = id;
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "ItemListDTO{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
