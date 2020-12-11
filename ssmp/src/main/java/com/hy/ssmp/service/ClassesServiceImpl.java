package com.hy.ssmp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssmp.mapper.ClassesMapper;
import com.hy.ssmp.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService{

    @Autowired
    private ClassesMapper classesMapper;


}
