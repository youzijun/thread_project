package com.ltt.threadPool;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZJX-BJ-01-00057 on 2018/6/5.
 */
public class CyclicBarrierTest {


    static class Runner implements Runnable{

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Runner(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000 * (new Random().nextInt(5)));

                System.out.println(this.name + "准备ok！");
                this.cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(this.name + "出发！");

        }
    }


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new Runner(cyclicBarrier, "张三"));
        executorService.execute(new Runner(cyclicBarrier, "李四"));
        executorService.execute(new Runner(cyclicBarrier, "王五"));

//        executorService.shutdown();

    }


}
