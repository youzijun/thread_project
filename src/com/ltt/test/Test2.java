package com.ltt.test;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by ZJX-BJ-01-00057 on 2018/12/20.
 */
public class Test2 {


    public static void main(String[] args) throws InterruptedException {

        StringBuffer str = new StringBuffer("bdjdhbekejbebdjdjcjcnjdiwjgwvvxjjcinnkkkmnkgg");
        System.out.println(str.reverse());

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE-1);



        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder.intValue());
        longAdder.increment();
        System.out.println(longAdder.intValue());


        Thread t = Thread.currentThread();
        t.setName("mainThread");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        while (true){
            System.out.println(Thread.activeCount());

            Thread.sleep(500);
        }


    }

}
