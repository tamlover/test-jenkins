package com.quartztest.testdemo.thread;

/**
 * @author qili.hu
 * @date 2018/10/12 9:00
 */
public class MyService {
    public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            System.out.println(Thread.currentThread().getName() + "__" + list.getSize());
            synchronized (list) {
                if (list.getSize() < 1) {
                    System.out.println("come in");
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
