package com.hy.ssm.controller;

import com.hy.ssm.pojo.Classes;
import com.hy.ssm.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@Transactional
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/queryAll")
    @ResponseBody//如果直接返回list要到Jackson.jar包  还要加ResponseBody
    public ArrayList<Classes> queryAll() {
        return classesService.queryClaName();
    }

}
