package com.quartztest.testdemo.thread;

import java.util.Objects;

/**
 * @author qili.hu
 * @date 2018/10/12 10:54
 */
public class DeadThread implements Runnable {
    public String name;
    public Object lock1 = new Object();
    public Object lock2 = new Object();


    public void setFlag(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        if ("a".equals(name)) {
            synchronized (lock1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "_username_ " + name);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("lock2");
                }
            }
        }
        if ("b".equals(name)) {
            synchronized (lock2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "_username_ " + name);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("lock1");
                }
            }
        }

    }
}
