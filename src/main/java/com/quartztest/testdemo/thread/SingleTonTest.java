package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 16:40
 */
public class SingleTonTest {
    public static void main(String[] args) {
        MyThread33 thread33 = new MyThread33();
        MyThread33 thread331 =new MyThread33();
        MyThread33 thread332 = new MyThread33();

        thread33.start();
        thread331.start();
        thread332.start();

    }
}
