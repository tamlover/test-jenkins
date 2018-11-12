package com.quartztest.testdemo.thread.notify;

/**
 * @author qili.hu
 * @date 2018/10/12 13:42
 */
public class ThreadB extends Thread {
    private Object lock;
    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized(lock) {
                for (int i =0;i<10;i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("send notify");
                    }
                    System.out.println("add " + (i+1) + "ele");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
