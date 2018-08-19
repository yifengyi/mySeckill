package org.wujf.seckill.exception;

/**
 * 重复秒杀异常
 * @author wujf
 * @version 1.0 create time 14:32 2018/8/19
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
