package com.cm.rabbitmq.service.impl;

import com.alibaba.fastjson.JSON;
import com.cm.rabbitmq.domain.dto.ProviderDTO;
import com.cm.rabbitmq.service.IRabbitMQService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/30 16:21
 */
@Service
public class RabbitMQServiceImpl implements IRabbitMQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQServiceImpl.class);

    @Override
    public void sendMessage(ProviderDTO providerDTO) {
        if (providerDTO.getId() == null) {
            providerDTO.setId(UUID.randomUUID().toString());
        }
            publish(providerDTO);
    }

    protected void publish(ProviderDTO providerDTO){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setVirtualHost("/demo");
            factory.setUsername("admin");
            factory.setPassword("123456");
            Connection conn = factory.newConnection();
            Channel channel = conn.createChannel();
            // 发布消息，需要参数：交换器，路由键。最后一个参数为消息内容
            // 注意：RabbitMQ的消息类型只有一种，那就是byte[]
            channel.basicPublish(providerDTO.getExchange(), providerDTO.getRoutingKey(), null, JSON.toJSONString(providerDTO.getData()).getBytes("utf-8"));
            //关闭信道和连接
            channel.close();
            conn.close();
        } catch (IOException e) {
            logger.error("发布信息时，出现IOE异常，{}", JSON.toJSONString(providerDTO));
        } catch (TimeoutException e) {
            logger.error("发布信息时，出现Timeout异常，{}", JSON.toJSONString(providerDTO));
        }
    }
}
