package org.wujf.seckill.service;

import org.wujf.seckill.dto.Exposer;
import org.wujf.seckill.dto.SeckillExecution;
import org.wujf.seckill.entity.Seckill;
import org.wujf.seckill.exception.RepeatKillException;
import org.wujf.seckill.exception.SeckillClosedException;
import org.wujf.seckill.exception.SeckillException;

import java.util.List;

/**
 *
 * @author wujf
 * @version 1.0 create time 14:17 2018/8/19
 */
public interface SeckillService {

    /**
     * 查询所有的秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址,
     * 否则输出系统时间和秒杀时间s
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException,RepeatKillException,SeckillClosedException;
}
