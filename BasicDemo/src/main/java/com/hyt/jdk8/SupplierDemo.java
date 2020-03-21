package com.hyt.jdk8;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-22 0:28
 * @since 1.8
 **/
public class SupplierDemo {

    public static void main(String[] args) {
        printMax(() -> {
            int[] arr = {10, 20, 100, 30, 40, 50};
            // 先排序,最后就是最大的
            Arrays.sort(arr);
            // 最后就是最大的
            return arr[arr.length - 1];
        });
    }

    private static void printMax(Supplier<Integer> supplier) {
        int max = supplier.get();
        System.out.println("max = " + max);
    }
}
