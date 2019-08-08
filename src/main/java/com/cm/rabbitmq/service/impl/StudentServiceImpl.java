package com.cm.rabbitmq.service.impl;

import com.alibaba.fastjson.JSON;
import com.cm.rabbitmq.constant.AssertConstant;
import com.cm.rabbitmq.constant.RabbitMQConstant;
import com.cm.rabbitmq.constant.RedisConstant;
import com.cm.rabbitmq.dao.IStudentDao;
import com.cm.rabbitmq.domain.dto.ProviderDTO;
import com.cm.rabbitmq.domain.entity.Student;
import com.cm.rabbitmq.service.IRabbitMQService;
import com.cm.rabbitmq.service.IRedisService;
import com.cm.rabbitmq.service.IStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/30 9:49
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Autowired
    private IRedisService redisService;
    @Autowired
    private IRabbitMQService rabbitMQService;

    @Override
    public Student save(Student student) {
        Assert.notNull(student, AssertConstant.STUDENT_IS_NOT_NULL);
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setExchange(RabbitMQConstant.EXCHANGE_DEMO);
        providerDTO.setRoutingKey(RabbitMQConstant.ROUTING_DEMO);
        providerDTO.setData(student);
        rabbitMQService.sendMessage(providerDTO);
        return student;
    }

    @Override
    public Student get(Integer id) {
        Assert.notNull(id, AssertConstant.STUDENT_ID_IS_NOT_NULL);
        Student student = null;
        StringBuffer sb = new StringBuffer(RedisConstant.STUDENT_KEY_PREFIX);
        String key = sb.append(id).toString();
        String value = (String) redisService.getObj(key);
        if (StringUtils.isNotEmpty(value)) {
            student = JSON.parseObject(value, Student.class);
        } else {
            student = studentDao.get(id);
            redisService.save(key, JSON.toJSONString(student));
        }
        return student;
    }
}
