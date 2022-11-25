package com.example.app3.mysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {//辅助类

    private static final String DB_NAME = "sqltest.db";
    public static final int DB_VERSION = 3;//数据库升级，修改版本号

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);//创建数据库
    }

    //初次创建
    @Override
    public void onCreate(SQLiteDatabase db) {
        int initDBVersion = 1;
        db.execSQL(StudentDao.SQL_CREATE_TABLE);//创建表
//        db.execSQL(XXXDao.SQL_CREATE_TABLE);//创建表
        onUpgrade(db, initDBVersion, DB_VERSION);//
    }



        //版本升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = oldVersion; i < newVersion; i++) {
            switch (i) {
                case 1://1-2
                    DBHelper.upToDbVersion2(db);
                    break;
                case 2://2-3
                    DBHelper.upToDbVersion3(db);
                    break;
                    //.....
                default:
                    break;
            }
        }
    }

    //增加一列
    public static void upToDbVersion2(SQLiteDatabase db) {
        String updateSql = "alter table " + StudentDao.TABLE_NAME + " add column score varchar(5)";
        db.execSQL(updateSql);
    }

    //修改数据库内容
    public static void upToDbVersion3(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("score", 100);
        db.update(StudentDao.TABLE_NAME, values, null, null);
    }

}
