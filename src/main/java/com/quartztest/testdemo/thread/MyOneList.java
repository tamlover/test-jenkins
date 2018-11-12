package com.quartztest.testdemo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qili.hu
 * @date 2018/10/12 8:58
 */
public class MyOneList {
    private List list = new ArrayList();
    synchronized public void add(String data) {
        System.out.println(Thread.currentThread().getName()+":come in");
        list.add(data);
    }

   synchronized public int getSize() {
        return list.size();
    }
}
