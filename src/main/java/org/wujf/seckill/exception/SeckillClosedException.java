package org.wujf.seckill.exception;

/**
 * 秒杀关闭异常
 * @author wujf
 * @version 1.0 create time 14:34 2018/8/19
 */
public class SeckillClosedException extends SeckillException {

    public SeckillClosedException(String message) {
        super(message);
    }

    public SeckillClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
