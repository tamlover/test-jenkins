package com.quartztest.testdemo.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author qili.hu
 * @date 2018/10/11 14:09
 */
public class QuartzTest {

    public static void main(String[] args) throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        Map map = new HashMap();
//        map.put("add","adaq");
//        map.put("delete","deadad");

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("type", "asda");
//        jobDataMap.put("message", map);
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = MyJob.class.getName();


        JobDetail jobDetail = newJob(MyJob.class)
                .usingJobData(jobDataMap)
                .withIdentity(name,group)
                .build();

        Trigger trigger = newTrigger()
                .withIdentity(name,group)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInMilliseconds(1000)
                        .withRepeatCount(10))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

}
