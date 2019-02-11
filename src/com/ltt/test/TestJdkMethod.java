package com.ltt.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by ZJX-BJ-01-00057 on 2018/12/20.
 */
public class TestJdkMethod {


    private static volatile int longAdder = 0;

    private static void increment(){
        longAdder++;
    }

    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(100);

        final TestJdkMethod testJdkMethod = new TestJdkMethod();

        for(int i = 0; i < 1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testJdkMethod.increment();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(longAdder);
    }

}
