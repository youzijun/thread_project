package com.ltt.threadPool;

/**
 * Created by ZJX-BJ-01-00057 on 2018/6/5.
 */
public class MyTask implements Runnable{

    private String id;

    public MyTask(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is " + this.id);
    }

}
