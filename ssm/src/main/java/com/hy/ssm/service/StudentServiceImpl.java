package com.hy.ssm.service;

import com.hy.ssm.dao.StudentMapper;
import com.hy.ssm.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    //service调dao层：组合Dao
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int save(Student student) {
        return studentMapper.save(student);
    }

    @Override
    public int delete(String id) {
        return studentMapper.delete(id);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Student queryById(String id) {
        return studentMapper.queryById(id);
    }

    @Override
    public ArrayList<Student> queryAll(String search) {
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
        return studentMapper.queryAll(search);
    }


}
