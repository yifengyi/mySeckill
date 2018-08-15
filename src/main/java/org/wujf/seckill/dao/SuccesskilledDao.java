package org.wujf.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.wujf.seckill.entity.Successkilled;

/**
 * @author wujf
 * @version 1.0v  create in 17:52 2018-8-15
 */
public interface SuccesskilledDao {

    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数，如果返回值<1则表示插入失败
     */
    int addSuccesskilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀商品对象实体
     * @param seckillId
     * @param userPhone
     * @return
     */
    Successkilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
