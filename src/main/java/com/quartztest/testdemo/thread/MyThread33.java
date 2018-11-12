package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 16:40
 */
public class MyThread33 extends Thread{
    @Override
    public void run(){
        System.out.println(SomeThing.INSTANCE.getInstance().hashCode());
    }
}
