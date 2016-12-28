package com.example.administrator.messagehand.bean;

/**
 * Created by Administrator on 2016/11/29.
 */

public class Person {
    String name;
    String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String toString(){
        return name+"--"+sex;
    }
}
