package com.hy.ssm.controller;

import com.hy.ssm.pojo.Student;
import com.hy.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("student")
@ComponentScan
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @RequestMapping(value = "/queryAll")
    public String queryAll(Model model, String name) {
        model.addAttribute("list", studentService.queryAll(name));
        return "page";
    }

    @RequestMapping(value = "/save")
    public String save(Student student, @RequestParam("filename") MultipartFile pictureFile, HttpServletRequest request) {
        try {
            String picName = UUID.randomUUID().toString();
            String oriName = pictureFile.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            File file = new File(request.getServletContext().getRealPath("/") + "/upload/" + picName + extName);
            pictureFile.transferTo(file);
            student.setImg(picName + extName);
            studentService.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/student/queryAll";
    }

    @PostMapping("/queryById/{id}")
    @ResponseBody//如果直接返回list要到Jackson.jar包  还要加ResponseBody
    public Student queryById(@PathVariable("id") String id) {
        Student student = studentService.queryById(id);
        return student;
    }

    @RequestMapping(value = "/update")
    public String update(Student student, @RequestParam("filename") MultipartFile pictureFile, HttpServletRequest request) throws IOException {
        if (!StringUtils.isEmpty(pictureFile.getOriginalFilename())) {
            String picName = UUID.randomUUID().toString();
            String oriName = pictureFile.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            File file = new File(request.getServletContext().getRealPath("/") + "/upload/" + picName + extName);
            pictureFile.transferTo(file);
            student.setImg(picName + extName);
        }
        studentService.update(student);
        return "redirect:/student/queryAll";
    }

    @PostMapping("/delete/{id}")
    @ResponseBody//如果直接返回list要到Jackson.jar包  还要加ResponseBody
    public String delete(@PathVariable("id") String id) {
        int i = studentService.delete(id);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("/deletes")
    public String deletes(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            studentService.delete(ids[i]);
        }
        return "redirect:/student/queryAll";
    }

}