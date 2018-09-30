package com.ltt.pc;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by ZJX-BJ-01-00057 on 2018/4/23.
 */
public class MainPC {

    public static void main(String[] args){

        BlockingQueue<Data> blockingQueue = new LinkedBlockingDeque<Data>(20);

        Provider provider1 = new Provider(blockingQueue);
        Provider provider2 = new Provider(blockingQueue);
        Provider provider3 = new Provider(blockingQueue);

        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);
        Consumer consumer3 = new Consumer(blockingQueue);

        ExecutorService executorService = Executors.newCachedThreadPool();

        //创建子线程去生产和消费
        executorService.execute(provider1);
        executorService.execute(provider2);
        executorService.execute(provider3);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);

        try {
            //主进程休眠3秒钟
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        provider1.stop();
        provider2.stop();
        provider3.stop();

    }

}
