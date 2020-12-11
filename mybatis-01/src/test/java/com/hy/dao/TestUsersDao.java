package com.hy.dao;

import com.hy.pojo.UsersBean;
import com.hy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUsersDao {
    @Test
    public void test() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            List<UsersBean> list = usersMapper.queryAll();
            for (UsersBean usersBean : list) {
                System.out.println(usersBean.getId() + "-----" + usersBean.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getqueryById(){

        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            UsersBean usersBean = usersMapper.queryById(4);
            System.out.println(usersBean.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getAdd(){

        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            UsersBean usersBean = new UsersBean();
            usersBean.setId(5);
            usersBean.setName("张三");
            usersBean.setPassword("1232212");
            int i = usersMapper.add(usersBean);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void update(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            UsersBean usersBean = new UsersBean();
            usersBean.setId(5);
            usersBean.setName("狗蛋");
            usersBean.setPassword("1232212");
            int i = usersMapper.update(usersBean);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void add2(){

        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            Map map = new HashMap<String,Object>();
            map.put("idd",6);
            map.put("namee","王五");
            map.put("passwordd","12222321");
            map.put("idd",7);
            map.put("namee","赵六");
            map.put("passwordd","1233233");
            int i = usersMapper.add2(map);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void like(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
            List<UsersBean> list = usersMapper.querylike("李");
            for (UsersBean usersBean : list) {
                System.out.println(usersBean.getName());
            }
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
