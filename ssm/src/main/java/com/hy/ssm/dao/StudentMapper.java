package com.hy.ssm.dao;

import com.hy.ssm.pojo.Student;
import com.hy.ssm.util.DemoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface StudentMapper {
    //添加学生
    @SelectKey(statement = "select sys_guid() from dual",before = true,resultType = String.class,keyProperty = "id")
    @Insert(value = "insert into student (id,name,sex,classno,mgr,bdate,img) values (#{id},#{name},#{sex},#{classno},#{mgr},#{bdate},#{img})")
    int save(Student student);
    //删除学生
    @Delete("delete from student where id=#{stuId}")
    int delete(@Param("stuId") String id);
    //修改学生信息
    @Update("update student set name=#{name},sex=#{sex},classno=#{classno},mgr=#{mgr},bdate=#{bdate},img=#{img} where id=#{id}")
    int update(Student student);
    //根据ID查询学生信息
    @Select("select * from student where id=#{stuId}")
    Student queryById(@Param("stuId") String id);
    //查询所有学生信息
    /*@Results({
            @Result(column = "class_name",property = "classes.classname")
    })*/
//    @SelectProvider(type = DemoSqlProvider.class,method = "selectAll")
    ArrayList<Student> queryAll(@Param("name") String search);

}
