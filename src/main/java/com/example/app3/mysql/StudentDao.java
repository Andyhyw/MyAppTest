package com.example.app3.mysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.RatingBar;

import com.example.app3.model.Student;

import java.util.ArrayList;
import java.util.List;
//对应表的Dao
//@Dao
public class StudentDao {
    public static final String TABLE_NAME = "student";//表名

    private static final String ID = "id";//id自增长
    private static final String NAME = "name";//姓名
    private static final String AGE = "age";//年龄
    private static final String SEX = "sex";//性别
    private static final String GRADE = "grade";//年级
    //DB_Version2增加新字段
    private static final String SCORE = "score";

    private DBHelper dbHelper;
    static Context context;

    //创建表结构
    public static final String SQL_CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            ID + " integer primary key autoincrement," +
            NAME + " text," +
            AGE + " integer," +
            SEX + " varchar(5)," +
            GRADE + " text" +
            ")";


    private StudentDao() {
        dbHelper = new DBHelper(context);
    }

    public static StudentDao getInstance(Context _context) {
        context=_context;
        return InnerDB.instance;
    }

    private static class InnerDB {
        private static StudentDao instance = new StudentDao();
    }

    /**
     * 数据库插入数据
     * @param bean 实体类
     * @param <T>  T
     */
    public synchronized <T> void insert(T bean) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            if (bean != null && bean instanceof Student) {
                Student student = (Student) bean;
                ContentValues cv = new ContentValues();
                cv.put(NAME, student.getName());
                cv.put(AGE, student.getAge());
                cv.put(SEX, student.getSex());
                cv.put(GRADE, student.getGrade());
//                cv.put(SCORE, student.getScore());
                db.insert(TABLE_NAME, null, cv);
//                db.execSQL();
//                db.delete()

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    public synchronized<T>  int update(T bean){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        Student student = (Student) bean;
        contentValues.put(NAME, student.getName());
        contentValues.put(AGE, student.getAge());
        contentValues.put(SEX, student.getSex());
        contentValues.put(GRADE, student.getGrade());
        contentValues.put(SCORE,90);
        String [] strings ={"1"};
        return db.update(TABLE_NAME,contentValues,"id=?",strings);
    }

    /**
     * 删除表中所有的数据
     */
    public synchronized void clearAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from " + TABLE_NAME;

        try {
            db.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    /**
     * 查询数据
     *
     * @return List
     */
    public synchronized <T> List<T> query() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<T> list = new ArrayList<>();
        String querySql = "select * from " + TABLE_NAME;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(querySql, null);
            while (cursor.moveToNext()) {
                Student student = new Student();
                student.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                student.setAge(cursor.getInt(cursor.getColumnIndex(AGE)));
                student.setSex(cursor.getString(cursor.getColumnIndex(SEX)));
                student.setGrade(cursor.getString(cursor.getColumnIndex(GRADE)));
                student.setScore(cursor.getInt(cursor.getColumnIndex(SCORE)));
                list.add((T) student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return list;
    }
}
