package com.shantom.dao;

import com.shantom.pojo.User;
import com.shantom.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 1
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        List<User> userList = mapper.getUserList();

        //2
        List<User> userList = sqlSession.selectList("com.shantom.dao.UserDao.getUserList");

        userList.forEach(System.out::println);
    }
}