package com.shantom.dao;

import com.shantom.pojo.User;
import com.shantom.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 1
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        //2
//        List<User> userList = sqlSession.selectList("com.shantom.dao.UserDao.getUserList");

        userList.forEach(System.out::println);
    }
    @Test
    public void log4j(){
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.trace("trace");
    }

    @Test
    public void selectLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> res = mapper.getUserLike("%李%");
        res.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void selectOne(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 1
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserOne(1);

        System.out.println(user);
    }

    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.insertUser(new User(5, "哈哈", "123123"));
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(5, "hehe", "123123"));
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(5);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }
}