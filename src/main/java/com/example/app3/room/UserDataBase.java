package com.example.app3.room;

import android.content.Context;

import com.example.app3.model.Curse;
import com.example.app3.model.Usser;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Usser.class, Curse.class} , version = 1,exportSchema =false)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UsserDao usserDao();
    public abstract CurseDao curseDao();

    private static UserDataBase instance;

    public static synchronized UserDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, UserDataBase.class,"usertest.db")
                    //数据库存放在SD卡
//                    FileUtils.getDatabasePath("test.db"))
                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    //进行数据库升级
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
    //在这里用sql脚本完成
    database.execSQL("alter table usser add column flag integer not null default 1");
    }
    };
    static final Migration MIGRATION_2_3 =new Migration(2,3) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
            database.execSQL("alter table curse add column keshi integer not null default 1");
        }
    };

}
