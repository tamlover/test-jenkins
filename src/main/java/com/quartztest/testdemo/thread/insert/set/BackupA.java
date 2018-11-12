package com.quartztest.testdemo.thread.insert.set;


/**
 * @author qili.hu
 * @date 2018/10/12 14:27
 */
public class BackupA extends Thread {
    private DBTools dbTools;

    public BackupA(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}
