package com.cm.rabbitmq.domain.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/29 19:45
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -6240977583639071847L;
    private int id;
    private String name;
    private int age;
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
