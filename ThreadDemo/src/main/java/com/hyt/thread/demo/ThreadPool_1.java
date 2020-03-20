package com.hyt.thread.demo;

import com.hyt.thread.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-12 22:18
 * @since 1.8
 **/
public class ThreadPool_1 {

    public static void main(String[] args) throws Exception {
        List<String> taskNameList = new ArrayList<>();
        taskNameList.add("task1");
        taskNameList.add("task2");
        taskNameList.add("task4");
        taskNameList.add("task3");
        taskNameList.add("task5");

        method2(taskNameList);
    }

    private static void method2(List<String> taskNameList) throws Exception {
        long begin = System.currentTimeMillis();
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 存储执行结果的List
        List<Future<User>> results = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        // 提交任务
        for (String taskName : taskNameList) {
            Future<User> result = executorService.submit(new Callable<User>() {
                @Override
                public User call() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " sleep");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " awake");
                        System.out.println(" ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    User user = new User();
                    user.setUserName(taskName);
                    user.setAge(22);
                    user.setDesc(UUID.randomUUID().toString());
                    return user;
                }
            });
            // 将执行结果存入results中
            results.add(result);
        }
        executorService.shutdown();

        // 获取任务的返回结果
        for (int i = 0; i < results.size(); i++) {
            // 获取包含返回结果的future对象
            Future<User> future = results.get(i);
            // 从future中取出执行结果（若尚未返回结果，则get方法被阻塞，直到结果被返回为止）
            userList.add(future.get());
        }
        System.out.println("size1: " + userList.size());
        foreachUserList(userList);
        System.out.println("方法2 耗时：" + (System.currentTimeMillis() - begin));
    }

    private static void foreachUserList(List<User> userList) {
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
