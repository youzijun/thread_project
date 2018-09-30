package com.ltt.pc;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ZJX-BJ-01-00057 on 2018/4/23.
 *
 *  消费者
 */
public class Consumer implements Runnable{

    private BlockingQueue<Data> blockingQueue;


    public Consumer(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            //获取数据
            try {
                Data data = this.blockingQueue.take();
                Thread.sleep(1000);
                System.out.println("当前消费者线程为：" + Thread.currentThread().getName() + "消费完成，数据id为：" + data.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
