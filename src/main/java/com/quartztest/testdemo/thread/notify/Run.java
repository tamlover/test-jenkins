package com.quartztest.testdemo.thread.notify;

/**
 * @author qili.hu
 * @date 2018/10/12 13:45
 */
public class Run {
    public static void main(String[] args){
        try {


        Object lock = new Object();

        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        Thread.sleep(200);

        ThreadB threadB = new ThreadB(lock);
        threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
