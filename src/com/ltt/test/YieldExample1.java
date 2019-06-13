package com.ltt.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZJX-BJ-01-00057 on 2019/6/13.
 */
public class YieldExample1 {
    volatile static boolean flag = true;
    static Object ob = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while(true){
                synchronized (ob) {
                    if(!flag){
                        try {
                            ob.notify();
                            ob.wait();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("1111111111");
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while(true){
                synchronized (ob) {
                    if(flag){
                        try {
                            ob.notify();
                            ob.wait();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("2222222222");
                    flag = true;
                }
            }
        }).start();
    }
}
