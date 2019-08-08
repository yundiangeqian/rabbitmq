package com.cm.rabbitmq.constant;

import java.util.concurrent.TimeUnit;

/**
 * @description: Redis常量类
 * @author: caomian
 * @data: 2019/7/29 13:39
 */
public class RedisConstant {
    /**
     * redis普通保存的保存时间单位，到期自动清除
     */
    public static final TimeUnit REDIS_TIME_UNIT_MINUTES = TimeUnit.MINUTES;
    public static final TimeUnit REDIS_TIME_UNIT_SECONDS = TimeUnit.SECONDS;
    public static final TimeUnit REDIS_TIME_UNIT_DAYS = TimeUnit.DAYS;

    /**
     * 保存到redis的各种key的规则
     */
    public static final String STUDENT_KEY_PREFIX = "BSS:rabbitmq:student:";
}
