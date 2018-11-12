package com.quartztest.testdemo;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author qili.hu
 * @date 2018/10/15 16:46
 */
@Service
public class TestService2 {

    @Autowired
    private TestService service;

    public void test2(int retry, Map messge) throws SchedulerException {

        if (retry == 6) {
            System.out.println("重新发送！！");
            service.testTask();
        }
        System.out.println("retry: " +retry+ "  message: " +messge);
    }
}
