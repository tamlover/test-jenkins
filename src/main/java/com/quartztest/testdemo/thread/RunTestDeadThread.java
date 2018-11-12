package com.quartztest.testdemo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qili.hu
 * @date 2018/10/12 10:58
 */
public class RunTestDeadThread {

    public AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
        try {
            DeadThread deadThread1 = new DeadThread();

            deadThread1.setFlag("a");
            Thread t1 = new Thread(deadThread1);
            t1.start();
            Thread.sleep(1000);

            deadThread1.setFlag("b");
            Thread t2 = new Thread(deadThread1);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
