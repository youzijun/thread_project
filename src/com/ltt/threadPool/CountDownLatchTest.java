package com.ltt.threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ZJX-BJ-01-00057 on 2018/6/5.
 */
public class CountDownLatchTest {


    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("T1线程开始执行。。。");
                    Thread.sleep(7000);

                    System.out.println("T1线程开始等待。。。");
                    countDownLatch.await();
                    System.out.println("T1线程继续执行。。。");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("T2线程开始执行。。。");
                    Thread.sleep(5000);

                    System.out.println("T2线程初始化完毕，通知T1线程。。。");
                    countDownLatch.countDown();
                    System.out.println("T2线程继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("T3线程开始执行。。。");
                    Thread.sleep(5000);

                    System.out.println("T3线程初始化完毕，通知T1线程。。。");
                    countDownLatch.countDown();
                    countDownLatch.countDown();
                    System.out.println("T3线程继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }

}
