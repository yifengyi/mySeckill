package org.wujf.seckill.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.wujf.seckill.dao.SeckillDao;
import org.wujf.seckill.dao.SuccessKilledDao;
import org.wujf.seckill.dto.Exposer;
import org.wujf.seckill.dto.SeckillExecution;
import org.wujf.seckill.entity.Seckill;
import org.wujf.seckill.entity.SuccessKilled;
import org.wujf.seckill.enums.SeckillStatEnum;
import org.wujf.seckill.exception.RepeatKillException;
import org.wujf.seckill.exception.SeckillClosedException;
import org.wujf.seckill.exception.SeckillException;
import org.wujf.seckill.service.SeckillService;

import java.util.Date;
import java.util.List;

/**
 * @author wujf
 * @version 1.0 create time 14:39 2018/8/19
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    private final String slat = "sdfsQFD@#4@^^98(*&#@";

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;

        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillClosedException {
        if (md5 ==null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }

        try {
            Date now = new Date();
            int updateCount = seckillDao.reduceNumber(seckillId, now);

            if (updateCount<= 0) {
                throw new SeckillClosedException("seckill is colsed");
            } else {
                int insertCount = successKilledDao.addSuccesskilled(seckillId, userPhone);

                if (insertCount<=0) {
                    throw new RepeatKillException("seckill repated");
                }else{
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }

            }
        }catch (SeckillClosedException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
}
