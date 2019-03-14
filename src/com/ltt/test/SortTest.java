package com.ltt.test;

import java.util.PriorityQueue;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/15.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,8,9,0};
        searchTopK(nums, 4);
    }



    public static void searchTopK(int[] nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int val : nums){
            priorityQueue.add(val);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
                System.out.println(priorityQueue.peek());
            }
        }
        System.out.println(priorityQueue.peek());
    }

}
