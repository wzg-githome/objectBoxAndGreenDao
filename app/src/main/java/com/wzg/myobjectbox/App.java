package com.wzg.myobjectbox;

import android.app.Application;

import com.wzg.myobjectbox.ObjectBox_test.ObjectBox;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/28/028 10:51
 * desc: todo...
 */
public class App  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ObjectBox.init(this);
    }
}
