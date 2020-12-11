package com.hy.dao;

import com.hy.pojo.UsersBean;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    List<UsersBean> queryAll();
    UsersBean queryById(Integer id);
    int add(UsersBean usersBean);
    int update(UsersBean usersBean);
    int add2(Map<String,Object> map);
    List<UsersBean> querylike(String name);
}
