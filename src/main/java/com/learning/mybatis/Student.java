package com.learning.mybatis;

import java.util.Date;

/**
 * Entity必须满足：
 *
 * 1. 本身是一个公有的类
 * 2. 提供一个没有参数的默认构造函数
 * 3. 属性私有
 * 4. 属性setter和getter封装
 */
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name, String gender, Date birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public Student(Integer id, String name, String gender, Date birthday, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public void print() {
        System.out.println(id + " " + name + " " + gender
                + " " + birthday.toString() + " " + address);
    }
}
