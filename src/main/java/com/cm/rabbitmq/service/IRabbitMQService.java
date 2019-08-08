package com.cm.rabbitmq.service;

import com.cm.rabbitmq.domain.dto.ProviderDTO;

/**
 * @description:
 * @author:caomian
 * @data:2019/7/30 16:20
 */
public interface IRabbitMQService {
    /* *
     * @description: 把查到的数据推到rabbitMQ
     * @author: caomian
     * @param: [providerDTO]
     * @return: void
     * @date: 2019/7/30 16:29
     */
    void sendMessage(ProviderDTO providerDTO);
}
