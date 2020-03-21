package com.hyt.jdk8;

import java.util.function.Consumer;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-22 0:36
 * @since 1.8
 **/
public class ConsumerDemo {

    public static void main(String[] args) {
        // Lambda表达式
        test((String s) -> {
            System.out.println(s.toLowerCase());
        }, (String s) -> {
            System.out.println(s.toUpperCase());
        });
        // Lambda表达式简写
        test(s -> System.out.println(s.toLowerCase()),
                s -> System.out.println(s.toUpperCase()));
    }

    public static void test(Consumer<String> c1, Consumer<String> c2) {
        String str = "Hello World";
        // 先转小写
        c1.accept(str);
        // 再转大写
        c2.accept(str);
        // 自定义调用顺序，andThen为默认方法。
        c1.andThen(c2).accept(str);
        c2.andThen(c1).accept(str);
    }
}
