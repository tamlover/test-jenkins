package com.quartztest.testdemo;

import com.quartztest.testdemo.aop.UserDao;
import com.quartztest.testdemo.mybaties.TestUser;
import com.quartztest.testdemo.mybaties.TestUserMapper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestdemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(TestUserMapper.class);


    @Autowired
    private TestUserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        userDao.addUser();
    }

    @Test
    public void getAllUser() {
        System.out.println(userMapper.getAllUser().size());
    }

    @Test
    public void addUser() {
        TestUser testUse = new TestUser();
        testUse.setName("NICK");
        testUse.setSex("boy");
        userMapper.addUser(testUse);
        System.out.println(userMapper.getAllUser());
    }

    @Test
    public void getByUserName() {
        System.out.println(userMapper.getByUserName(""));
    }
}
