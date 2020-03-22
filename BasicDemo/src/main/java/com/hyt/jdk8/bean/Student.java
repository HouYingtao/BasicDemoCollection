package com.hyt.jdk8.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-22 20:56
 * @since 1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private int score;

}
