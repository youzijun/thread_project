package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2019/6/13.
 */
public class YieldExample {
    volatile static boolean flag = true;
    volatile static boolean OFF = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while(OFF){
                if(flag){
                    System.out.println("11111111111");
                    flag = false;
                }
            }
        }).start();

        new Thread(() -> {
            while(OFF){
                if(!flag){
                    System.out.println("22222222222");
                    flag = true;
                }
            }
        }).start();

        Thread.sleep(1);
        OFF = false;

    }
}
