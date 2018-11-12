package com.quartztest.testdemo.thread.notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qili.hu
 * @date 2018/10/12 13:38
 */
public class MyList {
    private static List list = new ArrayList();
    public static void add() {
        list.add("something");
    }

    public static int size() {
        return list.size();
    }
}
