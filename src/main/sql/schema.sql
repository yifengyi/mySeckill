--数据库初始化脚本
--创建数据库
CREATE DATABASE seckill;
--使用数据库
 use seckill;
--创建秒杀数据库
CREATE TABLE seckill(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

--初始化数据
INSERT INTO
    seckill(name,number,start_time,end_time)
VALUES
    ('1000元秒杀iphone6',100,'2018-08-19 00:00:00','2018-08-30 00:00:00'),
    ('500元秒杀ipd2',200,'2018-08-19 00:00:00','2018-08-30 00:00:00'),
    ('300元秒杀小米6',300,'2018-08-19 00:00:00','2018-08-30 00:00:00'),
    ('200元秒杀红米note',400,'2018-08-19 00:00:00','2018-08-30 00:00:00');

-- 秒杀明细表
-- 用户登陆认证相关信息
CREATE table success_kile(
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品id',
  `user_phone` bigint(11) NOT NULL COMMENT '用户手机号',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  `status` tinyint NOT NULL DEFAULT -1 COMMENT '状态表示:-1:无效 0：成功 1：已付款 2：已发货',
  PRIMARY KEY (seckill_id,user_phone),/* 联合主键*/
  key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀明细表';

--链接数据库的控制台

