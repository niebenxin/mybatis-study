package com.hy.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssmp.pojo.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentService extends IService<Student> {

    //查询所有学生信息
    IPage<Student> queryAll(String search,String pageIndex);
    IPage<Student> queryAllLay(String search,Integer page,Integer limit);
    Student queryById(String id);

}
