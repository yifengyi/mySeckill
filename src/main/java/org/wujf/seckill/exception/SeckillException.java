package org.wujf.seckill.exception;

/**
 * 秒杀异常
 * @author wujf
 * @version 1.0 create time 14:35 2018/8/19
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
