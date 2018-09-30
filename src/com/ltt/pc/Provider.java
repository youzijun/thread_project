package com.ltt.pc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ZJX-BJ-01-00057 on 2018/4/23.
 *
 *  生产者
 */
public class Provider implements Runnable{

    //消费队列
    private BlockingQueue<Data> blockingQueue;

    //控制生产者生产数据开关
    private volatile boolean isRunning = true;

    //自增id
    private static AtomicInteger countId = new AtomicInteger();


    public Provider(BlockingQueue<Data> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (isRunning){
            //模拟生产数据
            try {
                Thread.sleep(500);
                int id = countId.incrementAndGet();
                Data data = new Data(String.valueOf(id),"数据为：" + id);
                System.out.println("当前线程为：" + Thread.currentThread().getName() + "获取了数据，将id为：" + id + "的数据添加进消费队列。");
                if(!this.blockingQueue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("生产者将数据添加进队列失败！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //停止
    public void stop(){
        this.isRunning = false;
    }

}
