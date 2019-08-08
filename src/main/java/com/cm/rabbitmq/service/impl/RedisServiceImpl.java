package com.cm.rabbitmq.service.impl;

import com.cm.rabbitmq.constant.RedisConstant;
import com.cm.rabbitmq.service.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @description: redis业务操作的接口实现类
 * @author: caomian
 * @data: 2019/7/29 10:45
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Override
    public void save(String key, Object obj) {
        if(StringUtils.isEmpty(key)){
            logger.error("reids寻常插入,key不能为空",key);
        }else{
            redisTemplate.opsForValue().set(key, obj);
        }
    }

    @Override
    public void save(String key, Object obj, long expireTime) {
        if(StringUtils.isEmpty(key)){
            logger.error("reids定时插入,key不能为空",key);
        }else{
            redisTemplate.opsForValue().set(key, obj, expireTime, RedisConstant.REDIS_TIME_UNIT_SECONDS);
        }
    }

    @Override
    public Object getObj(String key) {
        if(StringUtils.isEmpty(key)){
            logger.error("reids获取记录,key不能为空",key);
            return null;
        }else{
            return redisTemplate.opsForValue().get(key);
        }
    }

    @Override
    public boolean delete(String key) {
        Assert.hasText(key, "key不能为空");
        return redisTemplate.delete(key);
    }

    @Override
    public Set<String> getAllKeys() {
        return redisTemplate.keys("*");
    }

    @Override
    public long decrement(String key) {
        Assert.hasText(key, "key不能为空");
        return redisTemplate.opsForValue().decrement(key, 1);
    }

    @Override
    public long increment(String key) {
        Assert.hasText(key, "key不能为空");
        return redisTemplate.opsForValue().increment(key, 1);
    }

    @Override
    public void saveToSet(String key, String value) {
        Assert.hasText(key, "key不能为空");
        stringRedisTemplate.opsForSet().add(key, value);
    }

    @Override
    public Set<String> getMembersFromSet(String key) {
        Assert.hasText(key, "key不能为空");
        return stringRedisTemplate.opsForSet().members(key);
    }

    @Override
    public boolean isContain(String key, String value) {
        Assert.hasText(key, "key不能为空");
        Assert.hasText(value, "value不能为空");
        return stringRedisTemplate.opsForSet().isMember(key, value);
    }

    @Override
    public void saveToListLeft(String key, Object value) {
        Assert.hasText(key, "key不能为空");
        redisTemplate.opsForList().leftPush(key, value);
    }

    @Override
    public Object getDataFromList(String key) {
        Assert.hasText(key, "key不能为空");
        return redisTemplate.opsForList().leftPop(key);
    }
}
