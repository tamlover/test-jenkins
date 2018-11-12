package com.quartztest.testdemo.task;

import com.quartztest.testdemo.log.ErrorTaskLog;
import com.quartztest.testdemo.log.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author qili.hu
 * @date 2018/10/15 13:36
 */
@Component
public class TaskIssueExecutor {

    private int retryCountTotal = 5;

    @Autowired
    private ITaskIssueService taskIssueService;

    @Autowired
    private TaskDao taskDao;

    void issueTask(String type, Object payload, int retryCount) {
        System.out.println("retryCount:"+retryCount);
        System.out.println("total:"+retryCountTotal);


//        ErrorTaskLog errorTaskLog = new ErrorTaskLog();
//        errorTaskLog.setType(type);
//
//        byte[] bytes = null;
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(bos);
//            oos.writeObject(payload);
//            oos.flush();
//            bytes = bos.toByteArray ();
//            oos.close();
//            bos.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        errorTaskLog.setPayload(bytes);
//
//        taskDao.save(errorTaskLog);

        ErrorTaskLog errorTaskLog = taskDao.getOne((long) 3);

        byte[] payload2 = errorTaskLog.getPayload();

        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (payload2);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("*********************");
        System.out.println(obj);


        if (retryCount < retryCountTotal) {
            System.out.println("type: " + type + " payload: " + payload);
        }else {
            System.out.println("次数太多");
        }
    }
}
