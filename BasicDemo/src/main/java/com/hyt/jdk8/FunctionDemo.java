package com.hyt.jdk8;

import java.util.function.Function;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-22 0:51
 * @since 1.8
 **/
public class FunctionDemo {

    public static void main(String[] args) {
        // Lambda表达式
        test((String s) -> {
            return Integer.parseInt(s);
        }, (Integer i) -> {
            return i * 10;
        });
        // Lambda 精简
        test(s -> Integer.parseInt(s), i -> i * 10);
    }

    public static void test(Function<String, Integer> f1, Function<Integer, Integer> f2) {
        // 将字符串解析成为int数字
        Integer in = f1.apply("66");
        // 将上一步的int数字乘以10
        Integer in2 = f2.apply(in);
        System.out.println("in2: " + in2);

        // andThen为默认方法。
        Integer in3 = f1.andThen(f2).apply("66");
        System.out.println("in3: " + in3);
    }
}
