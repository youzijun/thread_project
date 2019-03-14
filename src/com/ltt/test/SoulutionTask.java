package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2019/3/14.
 */
public class SoulutionTask implements Runnable{

    public static int value = 1;

    /**
     * 两个线程交替打印奇数和偶数
     */

    @Override
    public void run() {

        while(value < 100){

            //A线程获取锁，进入下面代码块，B线程阻塞在这里
            //A线程执行notify后，唤醒B线程，然后A执行wait释放锁，B线程获取锁以后进入代码块执行
            //notify和notifyAll只是唤醒等待状态的线程，然后等待锁的释放
            //执行wait操作后会释放拥有的锁
            synchronized (SoulutionTask.class) {

                System.out.println(Thread.currentThread().getName() + ": " + value++);
                SoulutionTask.class.notify();

                try {
                    SoulutionTask.class.wait();
                    System.out.println(111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        new Thread(new SoulutionTask(),"奇数").start();
        new Thread(new SoulutionTask(),"偶数").start();
    }


}
