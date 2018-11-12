package com.quartztest.testdemo.thread.stream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author qili.hu
 * @date 2018/10/12 14:41
 */
public class ReadData {

    public void readMeathod(PipedInputStream input) {
        try {
            System.out.println("read: ");
            byte[] bytes = new byte[30];
            int readLenth = input.read(bytes);

            while (readLenth != -1) {
                String readData = new String(bytes, 0, readLenth);
                System.out.println("readData:"+readData);
                readLenth = input.read(bytes);
            }
            System.out.println();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
