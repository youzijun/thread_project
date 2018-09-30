package com.ltt.zookeeperLock;

import org.apache.zookeeper.KeeperException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZJX-BJ-01-00057 on 2018/4/24.
 */
public class TestZkLock {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        TestThread testThread = new TestThread();

        //第一次获取锁
        executorService.execute(testThread);

        System.out.println("==========================");
        Thread.sleep(5*1000);

        //此处会循环重试获取锁
        executorService.execute(testThread);

        System.out.println("==========================");
        Thread.sleep(5*1000);

        //删除所有锁
        ZookeeperLock.getInstance().deleteLock(1L);

        System.out.println("==========================");
        Thread.sleep(5*1000);

        //再次获取锁
        executorService.execute(testThread);

    }


    static class TestThread implements Runnable{

        @Override
        public void run() {
            ZookeeperLock.getInstance().acquireZookeeperLock(1L);
        }

        public TestThread(){

        }
    }


}
