package com.wzg.myobjectbox.greenDao;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wzg.myobjectbox.R;
import com.wzg.myobjectbox.greenDao.GreenDaoManager;
import com.wzg.myobjectbox.greenDao.bean.InspectionReportRs;
import com.wzg.myobjectbox.greenDao.bean.ItemListDTO;
import com.wzg.myobjectbox.greenDao.gen.InspectionReportRsDao;

import java.util.ArrayList;
import java.util.List;


public class GreenDaoMainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity_LOG";

    private TextView result;


    private GreenDaoManager manager;
    private InspectionReportRsDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("GreenDao");

        manager = GreenDaoManager.getInstance(this);
        dao = manager.getInspectionReportRsDao();

        result = findViewById(R.id.result);

        findViewById(R.id.button).setOnClickListener(v -> _save());

        findViewById(R.id.button2).setOnClickListener(v -> {
            _update();
        });
        findViewById(R.id.button3).setOnClickListener(v -> {
            _remove();
        });
        findViewById(R.id.button4).setOnClickListener(v -> {
            _removeAll();
        });

        findViewById(R.id.button5).setOnClickListener(v -> {
            _updateInner();
        });
        findViewById(R.id.button7).setOnClickListener(v -> selectAll());


    }

    private void showToast(String string) {
        Toast.makeText(this, "" + string, Toast.LENGTH_SHORT).show();
    }

    /**
     * 删除单条数据
     */
    private void _remove() {
        dao.queryBuilder()
                .where(InspectionReportRsDao.Properties.ManagerName.eq("yh001"))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();

        Log.e(TAG, "_remove ---");
        showToast("删除成功");
        select();
    }

    /**
     * 修改第二层的数据
     */
    private void _updateInner() {
        InspectionReportRs yh001 = dao.queryBuilder()
                .where(InspectionReportRsDao.Properties.ManagerName.eq("yh001"))
                .build()
                .unique();

        if (yh001 == null) return;

        List<ItemListDTO> itemList = yh001.getItemList();

        for (ItemListDTO item : itemList) {
            if (item.getItemCode().equals("0001")) {
                item.setItemCode("0005");
            }
        }
        Log.e(TAG, "itemList : \n" + itemList.toString());
        yh001.setItemList(itemList);
        dao.update(yh001);

        Log.e(TAG, "_updateInner ---");
        showToast("更新第二层数据成功");
        select();
    }

    /**
     * 修改第一层的数据
     */
    private void _update() {

        InspectionReportRs yh001 = dao.queryBuilder()
                .where(InspectionReportRsDao.Properties.ManagerName.eq("yh001"))
                .build().unique();

        if (yh001 == null) return;

        yh001.setSchemeCode("0002");

        dao.update(yh001);

        Log.e(TAG, "_update ---");
        showToast("更新第一层数据成功");
        select();

    }


    /**
     * 查询并删除
     */
    private void _removeAll() {
        dao.queryBuilder()
                .where(InspectionReportRsDao.Properties.ManagerName.eq("yh001"))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();
        Log.e(TAG, "_removeAll ---");
        showToast("全部删除成功");
        select();
    }


    /**
     * 插入数据
     */
    private void _save() {

        InspectionReportRs datas = getDatas();
        long insertId = dao.insertOrReplace(datas);

        Log.e(TAG, "_save: " + insertId);
        showToast("保存成功");
        select();
    }

    /**
     * 查询数据
     */
    private void select() {
        result.setText("");
        InspectionReportRs yh001 = dao.queryBuilder()
                .where(InspectionReportRsDao.Properties.ManagerName.eq("yh001"))
                .build()
                .unique();


        if (yh001 == null) return;

        result.setText("index : " + index + "\n" + yh001.toString());

    }

    private void selectAll() {
        result.setText("");
        List<InspectionReportRs> yh001 = dao.queryBuilder()
                .build()
                .list();
        if (yh001 == null) return;
        result.setText("index : " + index + "\n" + yh001.toString());

    }


    int index = 0;

    private InspectionReportRs getDatas() {

        index++;

        InspectionReportRs inspectionReportRs = new InspectionReportRs();

        inspectionReportRs.setCreateTime("2021-11-12");
        inspectionReportRs.setId(1);
        inspectionReportRs.setSchemeCode("0001");
        inspectionReportRs.setManagerName("yh00" + index);


        ArrayList<ItemListDTO> list = new ArrayList<>();

        ItemListDTO i1 = new ItemListDTO();
        i1.setItemCode("0001");
        i1.setItemName("djfdksf");

        list.add(i1);

        ItemListDTO i2 = new ItemListDTO();
        i2.setItemCode("0002");
        i2.setItemName("dkfksdkf");
        list.add(i2);
        //
        inspectionReportRs.setItemList(list);

//        Log.e(TAG, "getDatas: "+list.toString());
        /**/

        ArrayList<String> strings = new ArrayList<>();
        strings.add("img1");
        strings.add("img2");
        //
        inspectionReportRs.setImgs(strings);


        return inspectionReportRs;
    }


}