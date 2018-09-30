package com.ltt.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZJX-BJ-01-00057 on 2018/6/5.
 */
public class UseThreadPoolTest2 {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5,
                10,
                120,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>() //无界队列
        );

        for(int i = 0; i < 20; i++){
            pool.execute(new MyTask(String.valueOf(i)));
        }

        System.out.println(pool.getQueue().size());

        try {
            Thread.sleep(4000);

            System.out.println(pool.getQueue().size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
