package org.wujf.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wujf.seckill.entity.SuccessKilled;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author wujf
 * @version 1.0 create time 0:50 2018/8/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void addSuccesskilled() {
        long id=1000L;
        long phone=15138152754L;
        int insertCount = successKilledDao.addSuccesskilled(id, phone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id=1000L;
        long phone=15138152754L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
    }
}