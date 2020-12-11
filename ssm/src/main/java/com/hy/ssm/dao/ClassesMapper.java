package com.hy.ssm.dao;

import com.hy.ssm.pojo.Classes;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ClassesMapper {

    Classes queryById(int classno);
    @Select("select * from classes")
    ArrayList<Classes> queryClaName();
}
