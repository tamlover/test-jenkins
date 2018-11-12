package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 9:03
 */
public class MyThread2 extends Thread{
    private MyOneList list;
    public MyThread2(MyOneList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(list, "B");
    }
}
