package com.wzg.myobjectbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wzg.myobjectbox.ObjectBox_test.ObjectBoxMainActivity;
import com.wzg.myobjectbox.greenDao.GreenDaoMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        findViewById(R.id.greenDao).setOnClickListener(v -> {
            startActivity(new Intent(this, GreenDaoMainActivity.class));
        });
        findViewById(R.id.ObjectBox).setOnClickListener(v -> {
            startActivity(new Intent(this, ObjectBoxMainActivity.class));
        });
    }
}