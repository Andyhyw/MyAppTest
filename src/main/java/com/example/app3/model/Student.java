package com.example.app3.model;


//对应表的实体类
//@Entity  //bean   model  实体类
public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    //Version2添加
    private String sex;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int age, String grade, String sex,int store) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.sex = sex;
        this.score =store;
    }
    public Student(String name, int age, String grade, String sex) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.sex = sex;
    }

    public Student(int id, String name, int age, String grade, String sex, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.sex = sex;
        this.score = score;
    }
}
