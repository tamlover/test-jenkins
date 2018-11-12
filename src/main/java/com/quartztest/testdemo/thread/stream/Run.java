package com.quartztest.testdemo.thread.stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author qili.hu
 * @date 2018/10/12 14:49
 */
public class Run {

    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            inputStream.connect(outputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
