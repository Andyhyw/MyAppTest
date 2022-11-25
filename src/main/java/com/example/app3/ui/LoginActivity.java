package com.example.app3.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.model.User;
import com.example.app3.sp.sputils.SharedPreferencesUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText account,password;
    TextView login;
    Context mContext;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext =this;


        initView();



        String user1name=(String) SharedPreferencesUtil.getData("user1name","");
        if (!"".equals(user1name) && null != user1name){
            //todo  跳转
        }




    }

    private void initView() {
        account =findViewById(R.id.acount);
        password =findViewById(R.id.password);
        login   =findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                //todo 判断账号密码是否正确，是否符合要求   之后  去请求后台接口，等待服务器返回，

                //todo  保存账号密码

                Intent intent =new Intent(mContext,MainActivity.class);
                startActivity(intent);

                break;

            default:
                break;
        }
    }


    public void  getResultForLoginAPI(User user){
        SharedPreferencesUtil.putData(SharedPreferencesUtil.USER_NAME,user.getAccount());
        SharedPreferencesUtil.putData(SharedPreferencesUtil.USER_PWD,user.getPassword());
    }


}
