package com.cm.rabbitmq.controller;

import com.alibaba.fastjson.JSON;
import com.cm.rabbitmq.domain.entity.Student;
import com.cm.rabbitmq.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/30 9:40
 */
@RequestMapping("/student")
@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    /* *
     * @description: 插入学生
     * @author: caomian
     * @param: [student]
     * @return: java.lang.String
     * @date: 2019/7/30 9:51
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public String saveStudent(Student student) {
        studentService.save(student);
        return JSON.toJSONString(student);
    }

    /* *
     * @description: 根据id查询学生
     * @author: caomian
     * @param: [id]
     * @return: java.lang.String
     * @date: 2019/7/30 13:55
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public String getStudent(Integer id) {
        Student student = studentService.get(id);
        if (StringUtils.isEmpty(student)) {
            return "没有改学生的信息";
        }
        return JSON.toJSONString(student);
    }

}
