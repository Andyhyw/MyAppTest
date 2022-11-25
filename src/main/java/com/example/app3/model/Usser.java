package com.example.app3.model;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity //(tableName = "user_table")
public class Usser {//json
    @PrimaryKey(autoGenerate = true)
    private int id;

//    @ColumnInfo(name = "user_name")
    private String name;
    private String sex;
    private String xueyuan;
    private String learnLanguage;
    private String account;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLearnLanguage() {
        return learnLanguage;
    }

    public void setLearnLanguage(String learnLanguage) {
        this.learnLanguage = learnLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public Usser(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    @Ignore
    public Usser(){

    }
}
