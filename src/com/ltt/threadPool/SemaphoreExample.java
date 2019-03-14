package com.ltt.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/19.
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        final int client = 3;
        final int threadCount = 10;
        Semaphore semaphore = new Semaphore(client);
        ExecutorService pool = Executors.newCachedThreadPool();
        int count = 0;
        while(++count < threadCount){
            System.out.println("=====" + count);
            pool.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("while1111=========" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println("while2222=========" + semaphore.availablePermits());
                }
            });
        }
        pool.shutdown();
    }

}
