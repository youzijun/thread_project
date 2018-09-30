package com.ltt.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZJX-BJ-01-00057 on 2018/6/5.
 */
public class UseThreadPoolTest1{

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), //有界队列
                new ExecutorException()  //拒绝策略
        );

//        System.out.println(pool.getPoolSize());

        MyTask task1 = new MyTask("1");
        MyTask task2 = new MyTask("2");
        MyTask task3 = new MyTask("3");
        MyTask task4 = new MyTask("4");
        MyTask task5 = new MyTask("5");
        MyTask task6 = new MyTask("6");

        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
//        System.out.println(pool.getPoolSize());
        pool.execute(task4);
        pool.execute(task5);
//        System.out.println(pool.getPoolSize());
//        System.out.println(pool.getCorePoolSize());
        pool.execute(task6);

        pool.shutdown();

    }

}
