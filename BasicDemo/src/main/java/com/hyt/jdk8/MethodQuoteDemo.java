package com.hyt.jdk8;

import org.junit.Test;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-22 15:36
 * @since 1.8
 **/
public class MethodQuoteDemo {

    @Test
    public void test1() {
        Function<String, Integer> f1 = (s) -> {
            return s.length();
        };
        System.out.println(f1.apply("abc"));

        Function<String, Integer> f2 = String::length;
        System.out.println(f2.apply("abc"));

        // 拿第一个参数作为方法的调用者
        BiFunction<String, Integer, String> bif = String::substring;
        String hello = bif.apply("hello", 2);
        System.out.println("hello = " + hello);
    }
}
