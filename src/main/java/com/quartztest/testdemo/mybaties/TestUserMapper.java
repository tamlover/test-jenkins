package com.quartztest.testdemo.mybaties;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author qili.hu
 * @date 2018/11/12 9:12
 */
@Mapper
public interface TestUserMapper {


    @Select("SELECT * FROM test_users")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex")
    })
    List<TestUser> getAllUser();

    @Insert("insert into test_users(name, sex)values(#{name},#{sex})")
    void addUser(TestUser testUser);


    @Select("SELECT * FROM test_users")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex")
    })
    List<TestUser> getAUser();


    @SelectProvider(type = UserDaoProvider.class, method = "findUserByName")
    List<TestUser> getByUserNam(String name);

    class UserDaoProvider {
        public String findUserByName(String name) {
            return new SQL() {
                {
                    SELECT("name, sex");
                    FROM("test_users");
                    WHERE("name LIKE '%" + name + "%'");
                }
            }.toString();
        }
    }
}
