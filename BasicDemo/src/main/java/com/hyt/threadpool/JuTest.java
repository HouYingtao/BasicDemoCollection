package com.hyt.threadpool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-25 22:31
 * @since 1.8
 **/
public class JuTest {

    private long begin = 0;

    private long end = 0;

    @Before
    public void before() {
        begin = System.currentTimeMillis();
    }

    @After
    public void after() {
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));
    }

    @Test
    public void threadPoolTest() {
        Random random = new Random();
        List<String> list = Arrays.asList("task1", "task2", "task3", "task4", "task5", "task6", "task7", "task8",
                "task12", "task13", "task14", "task15", "task16", "task17", "task18", "task22", "task23", "task24",
                "task25", "task26", "task27", "task28");
        try {
            MultiThreadUtil<String, People> multiThread = new MultiThreadUtil<String, People>(list) {
                @Override
                public People outExecute(int currentThread, String data) {
                    Thread t = Thread.currentThread();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("线程睡眠失败：" + t.getName());
                    }
                    System.out.println("当前线程号= " + t.getName() + " data=" + data);
                    People people = new People();
                    people.setName(data);
                    people.setAge(random.nextInt(100));
                    return people;
                }
            };
            List<People> resultList = multiThread.getResult();
            //获取每一批次处理结果
            System.out.println("获取处理结果........................");
            for (People people : resultList) {
                System.out.println(people);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
