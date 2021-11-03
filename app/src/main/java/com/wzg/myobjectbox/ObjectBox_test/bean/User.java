package com.wzg.myobjectbox.ObjectBox_test.bean;

import com.wzg.myobjectbox.ObjectBox_test.Converter.StringConverter;
import com.wzg.myobjectbox.ObjectBox_test.Converter.UserWorkDtoConverter;

import java.io.Serializable;
import java.util.ArrayList;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Unique;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/28/028 10:42
 * desc: ObjectBox
 */
@Entity
public class User implements Serializable {


    /**
     * 数据库规定必须有一个id
     */
    @Id
    public long Userid;

    @Unique
    public String name;
    public String sex;


    @Convert(converter = StringConverter.class, dbType = String.class)
    public ArrayList<String> imgs;
    @Convert(converter = UserWorkDtoConverter.class, dbType = String.class)
    public ArrayList<UserWork> userWorks;


    public User(long userid, String name, String sex, ArrayList<String> imgs, ArrayList<UserWork> userWorks) {
        Userid = userid;
        this.name = name;
        this.sex = sex;
        this.imgs = imgs;
        this.userWorks = userWorks;
    }

    public User() {
    }

    public long getUserid() {
        return Userid;
    }

    public void setUserid(long userid) {
        Userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    public ArrayList<UserWork> getUserWorks() {
        return userWorks;
    }

    public void setUserWorks(ArrayList<UserWork> userWorks) {
        this.userWorks = userWorks;
    }

    @Override
    public String toString() {
        return "User{" +
                "Userid=" + Userid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", imgs=" + imgs +
                ", userWorks=" + userWorks +
                '}';
    }
}
