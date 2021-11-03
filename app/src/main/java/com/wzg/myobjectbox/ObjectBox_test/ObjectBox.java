package com.wzg.myobjectbox.ObjectBox_test;

import android.content.Context;

import com.wzg.myobjectbox.ObjectBox_test.bean.MyObjectBox;

import io.objectbox.BoxStore;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/28/028 10:54
 * desc: objectX单例
 */
public class ObjectBox{

    private static BoxStore boxStore;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder()
                .androidContext(context.getApplicationContext())
                .build();
    }

    public static BoxStore get() {
        return boxStore;
    }




}
