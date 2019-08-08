package com.cm.rabbitmq.domain.dto;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/29 18:30
 */
public class ConsumerDTO extends RabbitMQBaseDTO{
    /** 队列 */
    private String queue;
    /** 交换机 */
    private String exchange;
    /** 路由键 */
    private String routingKey;

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
