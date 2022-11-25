package com.example.app3.mysql;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.app3.BaseApplication;
import com.example.app3.R;
import com.example.app3.model.Student;
import com.example.app3.model.User;
import com.example.app3.model.Usser;
import com.example.app3.room.CurseDao;
import com.example.app3.room.UserDataBase;
import com.example.app3.room.UsserDao;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class SqlActvity extends AppCompatActivity {
    Context context;
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        context =this;
        /**todo 第一步
         *  创建数据库
         *  首先创建一个类去继承SQLiteOpenHelper，创建一个sqltest.db的数据库
         *  第二步：创建dao，添加创建表和增删改查工作
         *  第三步：创建实体类，完善第二步，第一步
         */
        findViewById(R.id.create_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student("张三", 18, "三年级", "man");

                //TODO StudentDao.getInstance(getApplicationContext());  studentdao   dbhelper

                StudentDao.getInstance(getApplicationContext()).insert(student);
                /**
                 * insert()方法中调用了dbHelper.getWritableDatabase()，
                 * 此时没有test.db数据库则会去创建，接着执行onCreate()去创建了student表并插入了一条数据，
                 */

                Student b3 = new Student("李四", 18, "三年级", "man");
               StudentDao.getInstance(getApplicationContext()).update(b3);
                List<Usser> userList =new ArrayList<>();
                userList.add(new Usser("张三","m"));
                userList.add(new Usser("w","m"));
                userList.add(new Usser("e","m"));
                userList.add(new Usser("r","m"));
                userList.add(new Usser("t","m"));
                userList.add(new Usser("y","m"));

//                Usser usser =new Usser("ww","ee");
//
                UsserDao usserDao =UserDataBase.getInstance(getApplicationContext()).usserDao();
                CurseDao curseDao = UserDataBase.getInstance(getApplicationContext()).curseDao();
//              usserDao.insertUser(usser);
//                curseDao.insertAll();


                usserDao.insertAllList(userList);
//              UserDataBase.getInstance(getApplicationContext()).usserDao().insertAllList(userList);


            }
        });

    }
}
