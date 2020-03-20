package com.hyt.thread.domain;

import lombok.ToString;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-12 22:17
 * @since 1.8
 **/

@ToString
public class User {
    private String userName;
    private int age;
    private String desc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
