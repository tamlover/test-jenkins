package com.quartztest.testdemo.task;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author qili.hu
 * @date 2018/10/15 13:35
 */
@Component
public class TaskIssueJob extends QuartzJobBean {

    @Autowired
    private TaskIssueExecutor issueExecutor;

//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//
//        JobDataMap dataMap = context.getMergedJobDataMap();
//        issueExecutor.issueTask(dataMap.getString("type"), dataMap.get("payload"), dataMap.getInt("retryCount"));
//    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("为空吗？");
        System.out.println(issueExecutor == null);
        JobDataMap dataMap = context.getMergedJobDataMap();
        issueExecutor.issueTask(dataMap.getString("type"), dataMap.get("payload"), dataMap.getInt("retryCount"));
    }
}
