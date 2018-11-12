package com.quartztest.testdemo.log;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qili.hu
 * @date 2018/10/16 15:59
 */
public interface TaskDao extends JpaRepository<ErrorTaskLog, Long> {
}
