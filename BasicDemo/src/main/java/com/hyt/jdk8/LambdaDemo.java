package com.hyt.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-21 23:25
 * @since 1.8
 **/
public class LambdaDemo {

    public static void main(String[] args) {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        LambdaDemo demo = new LambdaDemo();
        features.forEach(demo::printStr);
    }
    private void printStr(String str) {
        System.out.println(str);
    }
    
}
