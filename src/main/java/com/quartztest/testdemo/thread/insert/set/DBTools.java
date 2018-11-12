package com.quartztest.testdemo.thread.insert.set;

/**
 * @author qili.hu
 * @date 2018/10/12 14:24
 */
public class DBTools {
    private boolean prebIsA = false;

    synchronized public void backupA () {
        try {
            while(prebIsA == true) {
                wait();
            }

            for (int i = 0; i< 5;i++) {
                System.out.println("+++++");
            }
            prebIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB () {
        try {
            while (prebIsA == false) {
                wait();
            }

            for (int i = 0; i< 5;i++) {
                System.out.println("-----");
            }
            prebIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
