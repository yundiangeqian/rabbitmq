package com.cm.rabbitmq.service.impl;

import com.cm.rabbitmq.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceImplTest {
    @Autowired
    private IRedisService redisService;

    @Test
    public void save() { redisService.save("b", 1); }

    @Test
    public void save1() {
        redisService.save("b", "321", 10);
    }

    @Test
    public void getObj() {
        System.out.println(redisService.getObj("b"));
    }

    @Test
    public void delete() {
        redisService.delete("a");
    }

    @Test
    public void getAllKeys() {
        System.out.println(redisService.getAllKeys());
    }

    @Test
    public void increment() {
        redisService.increment("e");
    }

    @Test
    public void decrement() { redisService.decrement("y"); }

    @Test
    public void saveToSet() {
        redisService.saveToSet("hl","aj");
        redisService.saveToSet("hl","zms");
        redisService.saveToSet("hl","mark");
    }

    @Test
    public void getMembersFromSet() {
        System.out.println(redisService.getMembersFromSet("hl"));
    }

    @Test
    public void isContain() {
        System.out.println(redisService.isContain("hl","aj"));
    }

    @Test
    public void saveToListLeft() {
        redisService.saveToListLeft("list","hello");
        redisService.saveToListLeft("list","world");
    }

    @Test
    public void getDataFromList() {
        System.out.println(redisService.getDataFromList("list"));
    }
}