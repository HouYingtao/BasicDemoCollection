package com.hyt.jdk8;

import com.hyt.jdk8.bean.Student;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-23 0:39
 * @since 1.8
 **/
public class StreamDemo {

    @Test
    public void test2() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77));
        // 统计数量
        Long count = studentStream.collect(Collectors.counting());
        System.out.println("count = " + count);
    }

    @Test
    public void test3() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77));
        Map<Integer, Map<String, List<Student>>> map =
                studentStream.collect(Collectors.groupingBy(s -> s.getAge(), Collectors.groupingBy(s -> {
                    if (s.getScore() >= 90) {
                        return "优秀";
                    } else if (s.getScore() >= 80 && s.getScore() < 90) {
                        return "良好";
                    } else if (s.getScore() >= 80 && s.getScore() < 80) {
                        return "及格";
                    } else {
                        return "不及格";
                    }
                })));
        map.forEach((k, v) -> {
            System.out.println(k + " == " + v);
        });
    }

    @Test
    public void test4() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 52, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77));
        // partitioningBy会根据值是否为true，把集合分割为两个列表，一个true列表，一个false列表。
        Map<Boolean, List<Student>> map = studentStream.collect(Collectors.partitioningBy(s ->
                s.getScore() > 90));
        map.forEach((k, v) -> {
            System.out.println(k + " == " + v);
        });
    }

    // parallelStream线程安全问题
    @Test
    public void parallelStreamNotice() {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(i -> {
                    list.add(i);
                });
        System.out.println("list = " + list.size());

        // 解决parallelStream线程安全问题方案一: 使用同步代码块
        Object obj = new Object();
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(i -> {
                    synchronized (obj) {
                        list.add(i);
                    }
                });

        // 解决parallelStream线程安全问题方案二: 使用线程安全的集合
        Vector<Integer> v = new Vector();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(i -> {
                    synchronizedList.add(i);
                });
        System.out.println("list = " + synchronizedList.size());

        // 解决parallelStream线程安全问题方案三: 调用Stream流的collect/toArray
        List<Integer> collect = IntStream.rangeClosed(1, 1000)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("collect.size = " + collect.size());
    }
}
