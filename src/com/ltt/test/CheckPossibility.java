package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2019/2/13.
 */
public class CheckPossibility {

    public static void main(String[] args) {
        int[] nums = {-1,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        if(len < 3){
            return true;
        }
        for(int i = 0; i < len - 2; i++){
            int pre = nums[i + 1];
            int next = nums[i + 2];
            if(pre > nums[i]){
                cnt++;
            }
            if(next < nums[i]){
                cnt++;
            }
        }
        return cnt < 2;
    }
//
//    public static boolean isSubsequence(String s, String t) {
//        int i = 0;
//        int j = 0;
//        char[] ss = s.toCharArray();
//        while(i < s.size() && j < t.size()){
//            if(s[i] == t[j]) i++;
//            j++;
//        }
//        return i == s.size();
//    }
//
//
//    public static int eraseOverlapIntervals(Interval[] intervals) {
//
//    }

}
