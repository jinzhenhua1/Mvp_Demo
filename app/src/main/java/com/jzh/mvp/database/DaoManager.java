package com.jzh.mvp.database;

import android.content.Context;

import com.dev.base.greendao.DaoMaster;
import com.dev.base.greendao.DaoSession;
import com.jzh.mvp.database.helper.MySqliteOpenHelper;

/**
 * <p></p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/29 10:24
 */
public class DaoManager {
    private static final String DB_NAME = "MVP_Demo.db";//数据库名称
    private static DaoManager mDaoManager;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private Context context;
    public DaoManager(Context context) {
        this.context = context;
    }

    /**
     * 使用单例模式获得操作数据库的对象
     *
     * @return
     */
    public static DaoManager getInstance(Context context) {
        if (mDaoManager == null) {
            synchronized (DaoManager.class) {
                if (mDaoManager == null) {
                    mDaoManager = new DaoManager(context);
                }
            }
        }
        return mDaoManager;
    }

    /**
     * 获取DaoSession
     *
     * @return
     */
    public synchronized DaoSession getDaoSession() {
        if (null == mDaoSession) {
            mDaoSession = getDaoMaster().newSession();
        }
        return mDaoSession;
    }

    /**
     * 设置debug模式开启或关闭，默认关闭
     *
     * @param flag
     */
    public  void setDebug(boolean flag) {
//        QueryBuilder.LOG_SQL = flag;
//        QueryBuilder.LOG_VALUES = flag;
    }



    /**
     * 关闭数据库
     */
    public synchronized void closeDataBase() {
        closeHelper();
        closeDaoSession();
    }

    /**
     * 判断数据库是否存在，如果不存在则创建
     *
     * @return
     */
    private DaoMaster getDaoMaster() {
        if (null == mDaoMaster) {
            mHelper = new MySqliteOpenHelper(context, DB_NAME, null);
            mDaoMaster = new DaoMaster(mHelper.getWritableDb());
        }
        return mDaoMaster;
    }

    private void closeDaoSession() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    private void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }
}
