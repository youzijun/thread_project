package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2019/3/14.
 */
public class SoulutionTask implements Runnable{

    public static int value = 1;

    /**
     * �����߳̽����ӡ������ż��
     */

    @Override
    public void run() {

        while(value < 100){

            //A�̻߳�ȡ���������������飬B�߳�����������
            //A�߳�ִ��notify�󣬻���B�̣߳�Ȼ��Aִ��wait�ͷ�����B�̻߳�ȡ���Ժ��������ִ��
            //notify��notifyAllֻ�ǻ��ѵȴ�״̬���̣߳�Ȼ��ȴ������ͷ�
            //ִ��wait��������ͷ�ӵ�е���
            synchronized (SoulutionTask.class) {

                System.out.println(Thread.currentThread().getName() + ": " + value++);
                SoulutionTask.class.notify();

                try {
                    SoulutionTask.class.wait();
                    System.out.println(111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        new Thread(new SoulutionTask(),"����").start();
        new Thread(new SoulutionTask(),"ż��").start();
    }


}
