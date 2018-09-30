package com.ltt.zookeeperLock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * zookeeper分布式锁解决方案
 *
 * 对每一个productId去zk中创建一个临时node节点
 * 如果当前productId已经创建了临时node，再次创建时zk会抛出 NodeExistsException异常
 */
public class ZookeeperLock {


//    静态内部类方式实现单例

//    private static class ZookeeperLockHandler{
//        private static ZookeeperLock zookeeperLock = null;
//        static{
//            zookeeperLock = new ZookeeperLock();
//        }
//    }
//
//    public static ZookeeperLock getInstance(){
//        return ZookeeperLockHandler.zookeeperLock;
//    }


    //双检查锁方式实现单例
    volatile private static ZookeeperLock zookeeperLock = null;

    public static ZookeeperLock getInstance(){
        if(zookeeperLock == null){
            synchronized (ZookeeperLock.class){
                if(zookeeperLock == null){
                    zookeeperLock = new ZookeeperLock();
                }
            }
        }
        return zookeeperLock;
    }


    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private ZooKeeper zookeeper;

    public ZookeeperLock(){

        //单例被静态方法创建时调用此无参构造器

        //主流程顺序往下执行，不会阻塞
        //zk启动的watcher监听器是异步去监听的
        //所以使用countDownLatch.await()去阻塞主线程
        try {
            this.zookeeper = new ZooKeeper("127.0.0.1:2181",5*1000,new ZookeeperLockWatcher());

            System.out.println("zk启动状态..." + zookeeper.getState());

            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * zookeeper 监听器
     */
    private class ZookeeperLockWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("zk启动监听器Watcher开始...");
            if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                System.out.println("zk启动成功...");
                countDownLatch.countDown();
            }
        }
    }


    /**
     * 获取分布式锁
     */
    public void acquireZookeeperLock(Long productId){
        String path = "/productId-lock-" + productId;
        try {

            // 关键方法，创建包含自增长id名称的目录，这个方法支持了分布式锁的实现
            // 四个参数：
            // 1、目录名称
            // 2、目录文本信息
            // 3、文件夹权限，Ids.OPEN_ACL_UNSAFE表示所有权限
            // 4、目录类型，（CreateMode.EPHEMERAL_SEQUENTIAL表示会在目录名称后面加一个自增加数字）此处使用EPHEMERAL
            this.zookeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("获取分布式锁成功，productId=" + productId);
        } catch (Exception e) {
            e.printStackTrace();
            //获取分布式锁失败，在这里一直等待-重试
            int count = 0;
            while (true){
                try {
                    Thread.sleep(500);
                    this.zookeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    count++;
                    System.out.println("循环-获取分布式锁【失败】，productId=" + productId + "-----循环次数为：" + count);
                    continue;
                }
                System.out.println("循环-获取分布式锁【成功】，productId=" + productId);
                break;
            }
        }
    }


    /**
     * 释放分布式锁
     */
    public void deleteLock(Long productId){
        try {
            this.zookeeper.delete("/productId-lock-" + productId, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


}
