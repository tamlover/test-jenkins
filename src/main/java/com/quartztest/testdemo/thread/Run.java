package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 9:04
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyOneList myOneList = new MyOneList();
        MyThread1 thread1 = new MyThread1(myOneList);
        MyThread2 thread2 = new MyThread2(myOneList);
        System.out.println("before listSize= " + myOneList.getSize());

        thread1.setName("A");
        thread1.start();

        thread2.setName("B");
        thread2.start();

        Thread.sleep(6000);
        System.out.println("listSize= " + myOneList.getSize());
    }
}
