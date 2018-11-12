package com.quartztest.testdemo.thread.stream;

import java.io.PipedInputStream;

/**
 * @author qili.hu
 * @date 2018/10/12 14:46
 */
public class ThreadRead extends Thread {

    private ReadData readData;
    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readData, PipedInputStream pipedInputStream){
        this.pipedInputStream = pipedInputStream;
        this.readData = readData;
    }

    @Override
    public void run() {
        readData.readMeathod(pipedInputStream);
    }
}
