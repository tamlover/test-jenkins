package com.quartztest.testdemo.thread.insert.set;

/**
 * @author qili.hu
 * @date 2018/10/12 14:29
 */
public class BackupB extends Thread {
    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
