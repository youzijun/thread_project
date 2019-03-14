package com.ltt.test;

import java.util.concurrent.*;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/18.
 */
public class ThreadTest extends Thread{

    public static void main(String[] args) throws InterruptedException {
//        ThreadTest threadTest = new ThreadTest();
//        threadTest.start();
//        threadTest.sleep(50);
//        System.out.println(111);
//        threadTest.interrupt();

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute();
//        executorService.shutdown();


        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Future task = pool.submit(new Runnable() {
            @Override
            public void run() {
                //
            }
        });
        task.cancel(true);
        pool.shutdownNow();
        System.out.println("main");



    }

//    @Override
//    public void run() {
//        System.out.println(456);
//        System.out.println(isInterrupted());
//        while(!isInterrupted()){
//            System.out.println(isInterrupted());
//        }
//        System.out.println("==============");
//        System.out.println(isInterrupted());
//        System.out.println(123);
//    }
//
//    public static void main(String[] args) {
//        ThreadTest threadTest = new ThreadTest();
//        Thread thread = new Thread(threadTest);
//        thread.start();
//    }

//    @Override
//    public Integer call() throws Exception {
//        return 123;
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadTest threadTest = new ThreadTest();
//        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(threadTest);
//        Thread thread = new Thread(integerFutureTask);
//        thread.start();
//        System.out.println(integerFutureTask.get());
//    }

}
