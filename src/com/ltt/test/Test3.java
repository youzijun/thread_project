package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2018/12/26.
 */
public class Test3 {


    public static void main(String[] args) {
        System.out.println(jump(5));
    }

    public static int jump(int n){
        if(n < 1) return n;
        int pre1 = 0;
        int pre2 = 1;
        int result = 0;
        for(int i = 1; i <= n; i++){
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

}
