package com.quartztest.testdemo.task;

/**
 * @author qili.hu
 * @date 2018/10/15 13:29
 */
public interface ITaskIssueService {

    /**
     * 任务下发
     * @param type 下发service的类型，例如：measurement, alarm
     * @param payload 下发内容
     */
    void issueTask(String type, Object payload);

    /**
     * 任务下发失败后可调用此接口重新下发
     * @param type type 下发service的类型，例如：measurement, alarm
     * @param payload 下发内容
     * @param retryCount 已重发的次数
     */
    void issueTask(String type, Object payload, int retryCount);
}
