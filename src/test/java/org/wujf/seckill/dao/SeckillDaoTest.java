package org.wujf.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wujf.seckill.entity.Seckill;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wujf
 * @version 1.0 create time 0:50 2018/8/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;


    @Test
    public void queryById() {
        long id=1000L;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> list = seckillDao.queryAll(0, 100);

        for (Seckill seckill : list) {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() {
        Date killTime = new Date();

        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println(updateCount);

    }



}