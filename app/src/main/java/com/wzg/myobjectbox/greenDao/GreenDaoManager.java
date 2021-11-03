package com.wzg.myobjectbox.greenDao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wzg.myobjectbox.greenDao.bean.InspectionReportRs;
import com.wzg.myobjectbox.greenDao.gen.DaoMaster;
import com.wzg.myobjectbox.greenDao.gen.DaoSession;
import com.wzg.myobjectbox.greenDao.gen.InspectionReportRsDao;

/**
 * You might think you can read it or optimize it, but no,you're wrong, Please  believe me. You'll see to do.
 * author:wzg
 * createTime: 2021/10/29/029 17:14
 * desc:greendao管理者
 */

public class GreenDaoManager {


    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;



    private static GreenDaoManager instance;

    private Context context;

    private static final String DB_NAME = "greenDao.db";


    /**
     * 单列
     *
     * @param context 上下文
     */
    public static GreenDaoManager getInstance(Context context) {

        if (instance == null) {
            synchronized (GreenDaoManager.class) {
                if (instance == null) {
                    instance = new GreenDaoManager(context);
                }
            }
        }
        return instance;
    }


    /**
     * 构造
     */
    private GreenDaoManager(Context context) {
        this.context = context;
        helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        master = new DaoMaster(getWritableDatabase());
        session = master.newSession();
//        mInspectionReportRsDao = session.getInspectionReportRsDao();
    }


    /**
     * 关闭操作
     */
    public void destroy() {
        closeHelper();
        closeSession();
    }


    private void closeSession() {
        if (session != null) {
            session.clear();
            session = null;
        }
    }

    private void closeHelper() {
        if (helper != null) {
            helper.close();
            helper = null;
        }
    }


    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        }
        SQLiteDatabase db = helper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        }
        return helper.getWritableDatabase();
    }


    /**
     * 存储的类
     *
     * @return 获取插入类的操作dao
     */
    public InspectionReportRsDao getInspectionReportRsDao() {
        return session.getInspectionReportRsDao();
    }


//    /**
//     * 会判断是替换和插入
//     *
//     * @param data 插入的数据
//     * @return 返回插入的id
//     */
//    public long insertOrReplace(InspectionReportRs data) {
//        return inspectionReportRsDao.insertOrReplace(data);
//    }
//
//    /**
//     * 插入一条记录，表里面要没有与之相同的记录
//     *
//     * @param data 插入的数据
//     * @return 返回插入的id
//     */
//    public long insert(InspectionReportRs data) {
//        return inspectionReportRsDao.insert(data);
//    }


    /**
     * 更新数据
     * @param personInfor
     */
//    public void update(InspectionReportRs personInfor){
//        InspectionReportRs mOldPersonInfor = inspectionReportRsDao
//        .queryBuilder()
//        .where(inspectionReportRsDao.Properties.Id.eq(personInfor.getId()))
//        .build()
//        .unique();//拿到之前的记录
//        if(mOldPersonInfor !=null){
//            mOldPersonInfor.setName("张三");
//            personInforDao.update(mOldPersonInfor);
//        }
//    }
//    /**
//     * 按条件查询数据
//     */
//    public List<PersonInfor> searchByWhere(String wherecluse){
//        List<PersonInfor>personInfors = (List<PersonInfor>) personInforDao
//        .queryBuilder()
//        .where(PersonInforDao.Properties.Name.eq(wherecluse))
//        .build()
//        .unique();
//        return personInfors;
//    }
//    /**
//     * 查询所有数据
//     */
//    public List<PersonInfor> searchAll(){
//        List<PersonInfor>personInfors=personInforDao.
//        queryBuilder()
//        .list();
//        return personInfors;
//    }
//    /**
//     * 删除数据
//     */
//    public void delete(String wherecluse){
//        personInforDao
//        .queryBuilder()
//        .where(PersonInforDao.Properties.Name.eq(wherecluse))
//        .buildDelete()
//        .executeDeleteWithoutDetachingEntities();
//    }


}
