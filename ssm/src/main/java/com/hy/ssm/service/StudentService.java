package com.hy.ssm.service;

import com.hy.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface StudentService {
    //添加学生
    int save(Student student);

    //删除学生
    int delete(String id);

    //修改学生信息
    int update(Student student);

    //根据ID查询学生信息
    Student queryById(String id);

    //查询所有学生信息
    ArrayList<Student> queryAll(String search);
}
