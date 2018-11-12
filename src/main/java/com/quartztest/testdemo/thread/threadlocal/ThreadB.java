package com.quartztest.testdemo.thread.threadlocal;

/**
 * @author qili.hu
 * @date 2018/10/12 15:52
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i <20; i++) {
                Tools.t1.set("ThreadB +" + i);
                System.out.println("ThreadB get value=" + Tools.t1.get());
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
