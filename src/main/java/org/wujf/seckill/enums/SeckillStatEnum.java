package org.wujf.seckill.enums;

/**
 * @author wujf
 * @version 1.0 create time 15:03 2018/8/19
 */
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_EROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;

    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum sateOf(int index){
        for (SeckillStatEnum statEnum : values()) {
            if (statEnum.getState() == index) {
                return statEnum;
            }
        }
        return null;
    }
}
