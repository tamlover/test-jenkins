package com.quartztest.testdemo.quartz;

import com.quartztest.testdemo.TestService2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @author qili.hu
 * @date 2018/10/11 14:08
 */
@Component
public class MyJob implements Job {

    @Autowired
    private TestService2 service;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        if (service != null) {
            System.out.println("successful");
        }

        try {

            JobDataMap dataMap = context.getMergedJobDataMap();
            System.out.println(dataMap.getString("type"));
            int retry = dataMap.getInt("retry");

            service.test2(retry, (Map) dataMap.get("message"));

            JobKey key = context.getJobDetail().getKey();

            System.out.println("instance:" + key + "当前时间戳：" + System.currentTimeMillis() +  " retry is: " +retry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
