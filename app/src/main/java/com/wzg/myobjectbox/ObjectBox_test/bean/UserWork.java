package com.wzg.myobjectbox.ObjectBox_test.bean;

import java.io.Serializable;



/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/28/028 11:03
 * desc: todo...
 */
public class UserWork implements Serializable {


    public String work;
    public String userCompany;

    public UserWork() {
    }

    public UserWork(String work, String userCompany) {
        this.work = work;
        this.userCompany = userCompany;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }


    @Override
    public String toString() {
        return "UserWork{" +
                "work='" + work + '\'' +
                ", userCompany='" + userCompany + '\'' +
                '}';
    }
}
