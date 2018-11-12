package com.quartztest.testdemo;

import com.quartztest.testdemo.quartz.MyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author qili.hu
 * @date 2018/10/11 15:59
 */
@Service
public class TestService {

    @Autowired
    private Scheduler scheduler;

    @Value("${retry.count}")
    String retryCount;

    public void testTask() throws SchedulerException {

        String type = "measure"+System.currentTimeMillis();

        JobDataMap jobDataMap = new JobDataMap();
        Map map = new HashMap(2);
        map.put("add","asd");
        jobDataMap.put("type", type);
        jobDataMap.put("retry", new Random().nextInt(10));
        jobDataMap.put("message", map);

        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = MyJob.class.getName();


        JobDetail jobDetail = newJob(MyJob.class)
                .usingJobData(jobDataMap)
                .withIdentity(name,group)
                .build();

        long now = System.currentTimeMillis();
        Date date = new Date(now+10*1000);
        Trigger trigger = newTrigger()
                .withIdentity(name,group)
                .startAt(date)
                .withSchedule(simpleSchedule()
                        .withIntervalInMilliseconds(1000)
                        .withRepeatCount(10)
                )
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

    }
}
