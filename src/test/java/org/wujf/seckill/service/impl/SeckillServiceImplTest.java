package org.wujf.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wujf.seckill.dto.Exposer;
import org.wujf.seckill.dto.SeckillExecution;
import org.wujf.seckill.entity.Seckill;
import org.wujf.seckill.exception.RepeatKillException;
import org.wujf.seckill.exception.SeckillClosedException;
import org.wujf.seckill.service.SeckillService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wujf
 * @version 1.0 create time 15:32 2018/8/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;


    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        long id =1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testSeckillLogic() throws Exception{
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}",exposer);
            long phone = 16134312313L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}",seckillExecution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillClosedException e){
                logger.error(e.getMessage());
            }
        }else {
            logger.warn("expose={}",exposer);
        }
    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000;

    }
}