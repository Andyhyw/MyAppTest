package com.example.app3.model;

import java.io.Serializable;


public class User implements Serializable {//json
    private int id;

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


    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public User() {
    }
}
