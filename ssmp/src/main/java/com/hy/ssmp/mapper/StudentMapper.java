package com.hy.ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.ssmp.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper extends BaseMapper<Student> {

    IPage<Student> queryAll(Page<Student> page, @Param("name")String name);

    @Select("select * from student where id=#{stuId}")
    Student queryById(@Param("stuId") String id);


}
