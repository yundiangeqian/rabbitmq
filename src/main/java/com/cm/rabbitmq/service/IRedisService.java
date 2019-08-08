package com.cm.rabbitmq.service;

import java.util.Set;

/**
 * @description: redis业务操作的接口
 * @author: caomian
 * @data: 2019/7/29 10:42
 */
public interface IRedisService {
    /* *
     * @description: 普通保存
     * @author: caomian
     * @param: [key, obj]
     * @return: void
     * @date: 2019/7/29 11:06
     */
    void save(String key, Object obj);

    /* *
     * @description: 在一定的时间内 保存该数据
     * @author: caomian
     * @param: [key, obj, expireTime]
     * @return: void
     * @date: 2019/7/29 11:21
     */
    void save(String key, Object obj, long expireTime);

    /* *
     * @description: 根据key获取记录数据
     * @author: caomian
     * @param: [key]
     * @return: java.lang.Object
     * @date: 2019/7/29 11:41
     */
    Object getObj(String key);

    /* *
     * @description: 根据key删除
     * @author: caomian
     * @param: [key]
     * @return: boolean
     * @date: 2019/7/29 11:42
     */
    boolean delete(String key);

    /* *
     * @description:获取所有key集合
     * @author: caomian
     * @param: []
     * @return: java.util.Set<java.lang.String>
     * @date: 2019/7/29 11:44
     */
    Set<String> getAllKeys();

    /* *
     * @description: 先检查key是否存在，存在+1，不存在先初始化，再+1 ,value必须是Integer
     * @author: caomian
     * @param: [key]
     * @return: long
     * @date: 2019/7/29 11:44
     */
    long increment(String key);

    /* *
     * @description: 先检查key是否存在，存在-1，不存在先初始化，再-1 ,value必须是Integer
     * @author: caomian
     * @param: [key]
     * @return: long
     * @date: 2019/7/29 15:38
     */
    long decrement(String key);

    /* *
     * @description: set保存
     * @author: caomian
     * @param: [key, value]
     * @return: void
     * @date: 2019/7/29 11:45
     */
    void saveToSet(String key, String value);

    /* *
     * @description: 获得set所有成员
     * @author: caomian
     * @param: [key]
     * @return: java.util.Set<java.lang.String>
     * @date: 2019/7/29 11:46
     */
    Set<String> getMembersFromSet(String key);

    /* *
     * @description: 判断key所保存的set集合是否包涵值为value的数据
     * @author: caomian
     * @param: [key, value]
     * @return: boolean
     * @date: 2019/7/29 11:47
     */
    boolean isContain(String key, String value);

    /* *
     * @description: 将指定的值插入到key的list的头部。如果key不存在，则在执行推送操作之前将其创建为空列表。（从左边插入）
     * @author: caomian
     * @param: [key, value]
     * @return: void
     * @date: 2019/7/29 11:47
     */
    void saveToListLeft(String key, Object value);

    /* *
     * @description: 根据key弹出list最左边的元素,弹出最后一个元素，key将会删除
     * @author: caomian
     * @param: [key]
     * @return: java.lang.Object
     * @date: 2019/7/29 11:48
     */
    Object getDataFromList(String key);
}
