package com.ltt.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/19.
 */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for(int i = 0; i < 1000; i++){
                    Thread.sleep(20);
                    result += i;
                }
                return result;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("=====================1111111111");
        System.out.println(futureTask.get());
        System.out.println("=====================1222222222");
//        while (true){
//            Thread.sleep(100);
//
//            System.out.println(futureTask.get());
//            System.out.println("--------------------");
//        }


    }

}
