package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 9:02
 */
public class MyThread1 extends Thread{
    private MyOneList list;
    public MyThread1(MyOneList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(list, "A");
    }
}
