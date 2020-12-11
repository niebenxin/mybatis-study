package com.hy.ssm.service;

import com.hy.ssm.dao.ClassesMapper;
import com.hy.ssm.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassesServiceImpl implements ClassesService{

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public ArrayList<Classes> queryClaName() {
        return classesMapper.queryClaName();
    }
}
