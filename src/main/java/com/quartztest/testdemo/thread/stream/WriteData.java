package com.quartztest.testdemo.thread.stream;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author qili.hu
 * @date 2018/10/12 14:37
 */
public class WriteData {

    public void writeMethod(PipedOutputStream out){
        try {
            System.out.println("write: ");
            for (int i = 0; i <20 ; i++) {
                String outData = "" + i;
                out.write(outData.getBytes());
                System.out.println("outData: " +outData);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
