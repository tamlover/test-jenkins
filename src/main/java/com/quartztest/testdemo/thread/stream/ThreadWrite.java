package com.quartztest.testdemo.thread.stream;

import java.io.PipedOutputStream;

/**
 * @author qili.hu
 * @date 2018/10/12 14:44
 */
public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedOutputStream outputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream pipedOutputStream) {
        this.writeData = writeData;
        this.outputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(outputStream);
    }
}
