package com.cm.rabbitmq.domain.dto;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/29 18:16
 */
public class ProviderDTO extends RabbitMQBaseDTO{
    /** 交换机 */
    private String exchange;
    /** 路由键 */
    private String routingKey;

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
