package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/13.
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] num = {1,4,6,7,8,8,10,11,13,14,22,34,221};
        System.out.println(binartSearch(num, 11));
    }

    public static int binartSearch(int[] num, int target){
        int left = 0;
        int right = num.length - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(num[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}
