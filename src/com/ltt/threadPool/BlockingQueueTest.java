package com.ltt.threadPool;

import org.apache.commons.codec.binary.StringUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/20.
 */
public class BlockingQueueTest {

    private static BlockingQueue queue = new ArrayBlockingQueue(5);


    private static class Product extends Thread{
        @Override
        public void run() {
            try {
                queue.put("P");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P");
        }
    }

    private static class Consumer extends Thread{
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
//        for(int i = 0; i < 2; i++){
//            Product product = new Product();
//            product.start();
//        }
//        for(int i = 0; i < 5; i++){
//            Consumer consumer = new Consumer();
//            consumer.start();
//        }
//        for(int i = 0; i < 3; i++){
//            Product product = new Product();
//            product.start();
//        }
//
//
//        List list = Collections.synchronizedList(new ArrayList<>());
//
//        List list1 = new CopyOnWriteArrayList();


        Integer[] nums = new Integer[3];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 1;
        List list = Arrays.asList(nums);
        System.out.println(list.size());
        list.add(1);



    }

}
