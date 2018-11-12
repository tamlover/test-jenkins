package com.quartztest.testdemo;

import com.quartztest.testdemo.log.ErrorTaskLog;
import com.quartztest.testdemo.log.TaskDao;
import com.quartztest.testdemo.task.ITaskIssueService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qili.hu
 * @date 2018/10/11 15:57
 */
@RestController
public class TestController {

    @Autowired
    private TestService service;

    @Autowired
    private ITaskIssueService taskIssueService;

    @Autowired
    private TaskDao taskDao;

    @PostMapping(value = "/task")
    public void testTask() throws SchedulerException {
        service.testTask();
    }

    @PostMapping(value = "/test")
    public void test2(@RequestBody Map payload) {
        taskIssueService.issueTask("measure", payload);
    }


    @GetMapping(value = "log")
    public void test3(){
        ErrorTaskLog log = taskDao.getOne((long) 3);
        byte[] payload = log.getPayload();

        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (payload);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(obj);
    }
}
