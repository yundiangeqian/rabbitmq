package com.cm.rabbitmq.config;

import com.cm.rabbitmq.constant.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: rabbitMQ的配置类
 * @author: caomian
 * @data: 2019/7/29 8:39
 */
@Configuration
public class RabbitMQConfig {
    /* *
     * @description: 创建交换机
     * @author: caomian
     * @param: []
     * @return: org.springframework.amqp.core.DirectExchange
     * @date: 2019/7/29 16:23
     */
    @Bean
    public DirectExchange demoExchange() {
        return new DirectExchange(RabbitMQConstant.EXCHANGE_DEMO, true, false);
    }

    /* *
     * @description:创建队列
     * @author: caomian
     * @param: []
     * @return: org.springframework.amqp.core.Queue
     * @date: 2019/7/29 16:23
     */
    @Bean
    public Queue demoQueue() {
        return new Queue(RabbitMQConstant.QUEUE_DEMO, true);
    }

    /* *
     * @description:  队列绑定交换机
     * @author: caomian
     * @param: []
     * @return: org.springframework.amqp.core.Binding
     * @date: 2019/7/29 16:26
     */
    @Bean
    public Binding demoBinding() {
        return BindingBuilder.bind(demoQueue()).to(demoExchange()).with(RabbitMQConstant.ROUTING_DEMO);
    }
}
