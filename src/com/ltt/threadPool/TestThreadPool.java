package com.ltt.threadPool;

import java.util.concurrent.*;

/**
 * Created by ZJX-BJ-01-00057 on 2018/4/23.
 */


class TestScheduledThreadPool extends Thread{
    public void run(){
        System.out.println("-----");
    }
}


public class TestThreadPool {


    public static void main(String[] args){

        //四种线程池

        /**
         * 线程池底层实现
         * 四种线程池传入参数不同，分为四种不同的线程池
         * 前三种和最后一个稍有不同
         * 1、核心线程数 （最小线程数）
         * 2、最大线程数
         * 3、线程空闲多久后关闭  空闲时间
         * 4、空闲时间的单位
         * 5、任务队列
         * new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
         */

        /**
         * 固定线程数量的线程池
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        /**
         * 只有一个线程的线程池
         */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();


        /**
         * 不限线程数量的线程池，使用无界队列
         */
        ExecutorService executorService2 = Executors.newCachedThreadPool();


        /**
         * 带定时器功能的线程池
         */
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        //Executors.newScheduledThreadPool(10);  demo
        TestScheduledThreadPool temp = new TestScheduledThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleWithFixedDelay((Runnable) temp, 4, 2, TimeUnit.SECONDS);
        //执行结果：延迟5秒加载执行temp任务，然后每隔三秒执行一次temp任务，循环。


        /**
         * 自定义线程池
         *
         * 有界队列 ArrayBlockingQueue
         * 无界队列 LinkedBlockingDeque
         */


        /**
         * 有界队列，拒绝策略
         * jdk默认提供四种拒绝策略。
         * 还可以实现RejectedExecutionHandler接口去自定义拒绝策略
         */
        //（注意任务进来的时机不同，执行的先后顺序不同）
        //有界队列
        //前五个任务进来时直接创建线程去执行
        //第六个任务进来时，此时线程数量已达到核心线程数量，任务放入有界队列中
        //直到核心线程数在执行任务中，队列也放满了，此时第十一个任务进来时，创建新线程去执行
        //当线程数量达到最大数量，任务队列也满了，此时新任务进来将执行拒绝策略。
        ExecutorService executorService4 = new ThreadPoolExecutor(
                5,          //最小线程数（核心线程数）
                10,     //最大
                60L,       //空闲关闭时间
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5)//有界队列 长度5
        );


        //无界队列
        //前五个任务进来时，直接创建线程去执行，当数据达到5时，任务入队，因为是无界队列，所以不会存在入队失败的情况。
        //实际上采用无界队列实现的线程池，maxSize并没有用。
        ExecutorService executorService5 = new ThreadPoolExecutor(
                5,
                10,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>()
        );

    }

}
