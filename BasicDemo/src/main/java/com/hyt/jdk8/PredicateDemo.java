package com.hyt.jdk8;

import java.util.function.Predicate;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-22 1:06
 * @since 1.8
 **/
public class PredicateDemo {

    public static void main(String[] args) {
        // Lambda表达式
        test((String s) -> {
            return s.contains("H");
        }, (String s) -> {
            return s.contains("W");
        });
        // Lambda 精简
        test(s -> s.contains("H"),
                s -> s.contains("W"));
    }

    public static void test(Predicate<String> p1, Predicate<String> p2) {
        String str = "HelloWorld";

        // 判断包含大写“H”
        boolean and1 = p1.test(str);
        // 判断包含大写“W”
        boolean and2 = p2.test(str);
        if (and1 && and2) {
            System.out.println("即包含W,也包含H");
        }
        boolean and = p1.and(p2).test(str);
        if (and) {
            System.out.println("即包含W,也包含H");
        }

        // 判断包含大写“H”
        boolean or1 = p1.test(str);
        // 判断包含大写“W”
        boolean or2 = p2.test(str);
        if (or1 || or2) {
            System.out.println("有H,或者W");
        }
        boolean or = p1.or(p2).test(str);
        if (or) {
            System.out.println("有H,或者W");
        }

        // 判断包含大写“H”
        boolean negate1 = p1.test(str);
        // 判断包含大写“W”
        boolean negate2 = p2.test(str);
        // 没有H,就打印
        if (!negate1) {
            System.out.println("没有H");
        }
        // 没有W,就打印
        if (!negate2) {
            System.out.println("没有W");
        }
        boolean negate = p1.negate().test(str);
        if (negate) {
            System.out.println("没有H");
        }
    }
}
