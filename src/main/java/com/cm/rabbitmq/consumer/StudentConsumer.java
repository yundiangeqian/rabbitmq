package com.cm.rabbitmq.consumer;

import com.alibaba.fastjson.JSON;
import com.cm.rabbitmq.constant.RabbitMQConstant;
import com.cm.rabbitmq.dao.IStudentDao;
import com.cm.rabbitmq.domain.entity.Student;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/29 20:46
 */
@Component
public class StudentConsumer {
    private final static Logger logger = LoggerFactory.getLogger(StudentConsumer.class);
    @Autowired
    private IStudentDao studentDao;

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConstant.QUEUE_DEMO)
    public void consumer() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("admin");
        factory.setPassword("123456");
        factory.setVirtualHost("/demo");


        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        //参数1表示限制条数，参数2 true=channel，false=消费者
        channel.basicQos(10, true);
        //开始消费，第二个参数表示是否自动确认
        channel.basicConsume(RabbitMQConstant.QUEUE_DEMO, false, new DefaultConsumer(channel) {
            // 当消息到达时执行回调方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                Student student = JSON.parseObject(message, Student.class);
                try {
                    //需要手动确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                    logger.info("消费回调确认：{}", message);
                    studentDao.save(student);
                } catch (IOException e) {
                    logger.error("消费消费失败：{}", message);
                    channel.basicNack(envelope.getDeliveryTag(), false,true);
                }
            }
        });

    }
}
