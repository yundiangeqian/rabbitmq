package com.cm.rabbitmq.dao;

import com.cm.rabbitmq.domain.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 学生的数据访问层
 * @author:caomian
 * @data:2019/7/30 9:55
 */
@Mapper
public interface IStudentDao {
    /* *
     * @description: 保存学生信息
     * @author: caomian
     * @param: [student]
     * @return: java.lang.Integer
     * @date: 2019/7/30 10:48
     */
    Integer save(Student student);

    /* *
     * @description: 根据学生id获取学生信息
     * @author: caomian
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2019/7/30 10:52
     */
    Student get(@Param("id") Integer id);
}
