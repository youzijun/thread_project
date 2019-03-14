package com.ltt.test;

import java.util.concurrent.Semaphore;

/**
 * Created by ZJX-BJ-01-00057 on 2019/3/14.
 */
public class SemaphoreTest {


    /**
     * 给N个线程顺序循环打印从0至100
     * 例如：
     * thread0: 0
     * thread1: 1
     * thread2: 2
     * thread0: 3
     * thread1: 4
     * @param args
     */

    /**  获取     释放
     * acquire release
     *
     * last cur i
         9  0   0
         0  1   1
         1  2   2
         2  3   3
         3  4   4
         4  5   5
         5  6   6
         6  7   7
         7  8   8
         8  9   9
     */

    static int index = 0;

    public static void main(String[] args) throws InterruptedException {

        final int n = 10;

        final int result = 100;

        Thread[] threads = new Thread[n];
        Semaphore[] semaphores = new Semaphore[n];
        for(int i = 0; i < n; i++){
            semaphores[i] = new Semaphore(1);
            if(i != n-1){
                semaphores[i].acquire();
            }
        }

        for(int i = 0; i < n; i++){
            final int j = i;
            final Semaphore last = i == 0 ? semaphores[n - 1] : semaphores[i - 1];
            final Semaphore cur = semaphores[i];
            threads[i] = new Thread(
                    () -> {
                        while(true){
                            try {
                                last.acquire();
                                System.out.println("thread-" + (j + 1) + ":" + index);
                                if(index++ >= result){
                                    System.exit(0);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }finally {
                                cur.release();
                            }
                            System.out.println();
                        }
                    });

            threads[i].start();

        }

    }

}
