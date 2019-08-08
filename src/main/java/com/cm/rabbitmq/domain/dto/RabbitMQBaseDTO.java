package com.cm.rabbitmq.domain.dto;

import java.io.Serializable;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/29 18:06
 */
public class RabbitMQBaseDTO implements Serializable {

    private static final long serialVersionUID = -4234411077102516102L;
    /**
     * 消息id
     */
    private String id;
    /**
     * 消息数据
     */
    private Object data;

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
