package com.quartztest.testdemo.quartz;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qili.hu
 * @date 2018/10/11 19:34
 */
public class MapTest {

    public static void main(String[] args) {
        Map map1 = new HashMap();
        Map map2 = new HashMap();

        map1.put("a","aaa");
        map2.put("a","aaa");
        map2.put("b", "bbb");

        System.out.println(map1.equals(map2));
    }
}
