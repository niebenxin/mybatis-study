package com.hy.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssmp.mapper.StudentMapper;
import com.hy.ssmp.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage<Student> queryAll(String search,String pageIndex) {
        if (!StringUtils.isEmpty(search)) {
            if ("男".equals(search)) {
                search = "M";
            }
            if ("女".equals(search)) {
                search = "F";
            }
        } else {
            search = "";
        }
        Page<Student> studentPage = new Page<>(Integer.parseInt(pageIndex),3);
        return studentMapper.queryAll(studentPage, search);
    }

    @Override
    public IPage<Student> queryAllLay(String search,Integer page,Integer limit) {
        if (!StringUtils.isEmpty(search)) {
            if ("男".equals(search)) {
                search = "M";
            }
            if ("女".equals(search)) {
                search = "F";
            }
        } else {
            search = "";
        }
        Page<Student> studentPage = new Page<>(page,limit);
        return studentMapper.queryAll(studentPage, search);
    }

    @Override
    public Student queryById(String id) {
        return studentMapper.queryById(id);
    }

}
