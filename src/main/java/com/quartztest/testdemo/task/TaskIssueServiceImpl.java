package com.quartztest.testdemo.task;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author qili.hu
 * @date 2018/10/15 13:32
 */
@Service
public class TaskIssueServiceImpl implements ITaskIssueService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void issueTask(String type, Object payload) {
        issueTask(type, payload, 0);
    }

    @Override
    public void issueTask(String type, Object payload, int retryCount) {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("type", type);
        jobDataMap.put("payload", payload);
        jobDataMap.put("retryCount", retryCount);

        System.out.println(jobDataMap.toString());

        String name = type + UUID.randomUUID().toString();
        String group = type;

        JobDetail jobDetail = newJob(TaskIssueJob.class)
                .usingJobData(jobDataMap)
                .withIdentity(name, group)
                .build();

        Trigger trigger = null;
        if (retryCount > 0) {

            //如果要重新下发任务则推迟1分钟发送
            Date date = new Date(System.currentTimeMillis() + 6 * 1000);

            trigger = newTrigger()
                    .withIdentity(name, group)
                    .startAt(date)
                    .build();
        } else {
            //如果是第一次下发即刻启动任务
            trigger = newTrigger()
                    .withIdentity(name, group)
                    .startNow()
//                    .withSchedule(simpleSchedule()
//                            .withIntervalInMilliseconds(1000)
//                            .withRepeatCount(10))
                    .build();
        }
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
