package com.ltt.threadPool;

/**
 * Created by ZJX-BJ-01-00057 on 2018/7/3.
 */
public class SingletonClass extends Thread{


    public static void main(String[] args) {

        SingletonClass[] mts = new SingletonClass[100];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new SingletonClass();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }

    @Override
    public void run() {
        System.out.println(MySingleton.getSingleton().hashCode());
    }


}
