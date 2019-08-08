package com.cm.rabbitmq.service;

import com.cm.rabbitmq.domain.entity.Student;

/**
 * @description:
 * @author:caomian
 * @data:2019/7/30 9:46
 */
public interface IStudentService {
    /* *
     * @description: 保存学生
     * @author: caomian
     * @param: [student]
     * @return: java.lang.Integer
     * @date: 2019/7/30 9:47
     */
    Student save(Student student);

    /* *
     * @description: 根据id获取学生信息
     * @author: caomian
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2019/7/30 9:48
     */
    Student get(Integer id);
}
