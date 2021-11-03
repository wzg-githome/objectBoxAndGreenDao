package com.wzg.myobjectbox.ObjectBox_test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wzg.myobjectbox.ObjectBox_test.bean.User;
import com.wzg.myobjectbox.ObjectBox_test.bean.UserWork;
import com.wzg.myobjectbox.ObjectBox_test.bean.User_;
import com.wzg.myobjectbox.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;

public class ObjectBoxMainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity_LOG";

    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ObjectBox");

        result = findViewById(R.id.result);

        findViewById(R.id.button).setOnClickListener(v -> _save());
        findViewById(R.id.button2).setOnClickListener(v -> _update());
        findViewById(R.id.button3).setOnClickListener(v -> _remove());
        findViewById(R.id.button4).setOnClickListener(v -> _removeAll());

        findViewById(R.id.button5).setOnClickListener(v -> _updateInner());

        findViewById(R.id.button7).setOnClickListener(v -> selectAll());


    }

    private void showToast(String string) {
        Toast.makeText(this, "" + string, Toast.LENGTH_SHORT).show();
    }


    private void _save() {


        Box<User> userBoxFor = ObjectBox.get().boxFor(User.class);

        User wzg = new User();
        wzg.setName("yh001");
        wzg.setSex("1");


        ArrayList<UserWork> userWorks = new ArrayList<>();

        UserWork userWork = new UserWork();
        userWork.setUserCompany("微视百科");
        userWork.setWork("IT");
        userWorks.add(userWork);

        UserWork userWork1 = new UserWork();
        userWork1.setUserCompany("home");
        userWork1.setWork("husband");
        userWorks.add(userWork1);

        //
        wzg.setUserWorks(userWorks);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1111");
        strings.add("1234");

        //
        wzg.setImgs(strings);


        User yh001 = userBoxFor.query(User_.name.equal("yh001")).build().findFirst();
        if (yh001 == null) {
            userBoxFor.put(wzg);

            showToast("插入成功");


            log();
        } else {
            showToast("yh001的数据已经存在");
        }


    }


    /**
     * 修改sex 为2
     */
    private void _update() {
        Box<User> userBoxFor = ObjectBox.get().boxFor(User.class);

        User yh001 = userBoxFor.query()
                .equal(User_.name, "yh001",
                        QueryBuilder.StringOrder.CASE_SENSITIVE)
                .build().findFirst();


        if (yh001 != null) {

            yh001.setSex("2");
            userBoxFor.put(yh001);

            showToast("修改第一层数据成功");

        }

        log();
    }

    /**
     * 修改内层数据  [IT 为 程序员]
     */
    private void _updateInner() {
        Box<User> userBoxFor = ObjectBox.get().boxFor(User.class);


        User yh001 = userBoxFor.query()
                .equal(User_.name, "yh001", QueryBuilder.StringOrder.CASE_SENSITIVE)
                .build().findFirst();

        if (yh001 != null) {
            ArrayList<UserWork> userWorks = yh001.getUserWorks();

            if (userWorks != null && userWorks.size() > 0) {
                for (UserWork item : userWorks) {
                    if (item.getWork().equals("IT")) {
                        item.setWork("程序员");
                    }
                }
            }
            yh001.setUserWorks(userWorks);
            userBoxFor.put(yh001);
            showToast("修改第二层数据成功");

        }
        log();

    }


    /**
     * 删除 name 为 jack_wzg1的数据
     */
    private void _remove() {
        Box<User> userBoxFor = ObjectBox.get().boxFor(User.class);

        User yh001 = userBoxFor.query(User_.name.equal("yh001"))
                .build().findFirst();

        if (yh001 != null) {
            userBoxFor.remove(yh001);
            showToast("删除数据成功");
        }

        /**
         * 查
         */
        log();


    }


    /**
     * 删除所有
     */
    private void _removeAll() {
        ObjectBox.get().boxFor(User.class).removeAll();
        /**
         * 查
         */
        showToast("删除所有数据成功");

        log();


    }


    private void log() {
        Log.e(TAG, "-------------------------------------开始--------------------------");

        User yh001 = ObjectBox.get().boxFor(User.class).query()
                .equal(User_.name, "yh001", QueryBuilder.StringOrder.CASE_SENSITIVE)
                .build().findFirst();
        if (yh001 == null) return;
        Log.e(TAG, "log: " + yh001.toString());
        result.setText(yh001.toString());


        Log.e(TAG, "-------------------------------------结束--------------------------\n\n");
    }

    @SuppressLint("SetTextI18n")
    private void selectAll() {
        Log.e(TAG, "-------------------------------------开始--------------------------");


        List<User> all = ObjectBox.get().boxFor(User.class).getAll();

        if (all == null) return;
        Log.e(TAG, "log:  size : " + all.size()
                + "\n" + all.toString());
        result.setText("size: " + all.size() +
                "\n" + all.toString());


        Log.e(TAG, "-------------------------------------结束--------------------------\n\n");
    }

}