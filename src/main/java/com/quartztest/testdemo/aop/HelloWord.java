package com.quartztest.testdemo.aop;

/**
 * @author qili.hu
 * @date 2018/10/24 15:03
 */
public class HelloWord {

    public void sayHello(){
        System.out.println("hello world !");
    }
    public static void main(String[] args){
        HelloWord helloWord =new HelloWord();
        helloWord.sayHello();
    }
}

