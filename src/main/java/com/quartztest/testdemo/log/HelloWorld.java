package com.quartztest.testdemo.log;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * @author qili.hu
 * @date 2018/10/16 15:18
 */

public class HelloWorld {
    public static void main(String[] args) {

//        int t = 0;
//        int oldT = 0;
//
//        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
//
//        logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);
//        logger.info("Hello World");
//        logger.error("error");
//        logger.warn("warn");

//        Map test = new HashMap();
//        test.put("add","ts");
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("payload", test);
//        map.put("errormessage", "error");

        String testNull = null;

        String oo = "adad" +testNull+"dasd";
        System.out.println(oo);

//        String content = JSONObject.toJSONString(map);
//        System.out.println(content);

    }
}
