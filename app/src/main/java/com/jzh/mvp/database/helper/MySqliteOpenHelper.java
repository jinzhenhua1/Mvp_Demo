package com.jzh.mvp.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.dev.base.greendao.DaoMaster;
import com.dev.base.greendao.UserDao;

import org.greenrobot.greendao.database.Database;

/**
 * <p>greendao默认升级数据库时会把旧表删除</p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/29 10:15
 */
public class MySqliteOpenHelper extends DaoMaster.DevOpenHelper {

    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 需要在实体类加一个字段 或者 改变字段属性等 就需要版本更新来保存以前的数据了
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);

        //这里添加要增加的字段
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, UserDao.class);

    }
}
