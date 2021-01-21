package com.shantom.dao;

import com.shantom.pojo.Blog;
import com.shantom.utils.IDUtils;
import com.shantom.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DynamicTest {

    @Test
    public void insertTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.insertBlog(new Blog(IDUtils.getID(), "Java", "狂老师", new Date(), 8888));
        mapper.insertBlog(new Blog(IDUtils.getID(), "MyBatis", "狂老师", new Date(), 6666));
        mapper.insertBlog(new Blog(IDUtils.getID(), "Spring", "狂老师", new Date(), 4444));
        mapper.insertBlog(new Blog(IDUtils.getID(), "微服务", "狂老师", new Date(), 2222));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDynamic(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
//        map.put("title", "%Java%");
        List<Blog> blogsWithConditions = mapper.getBlogsWithConditions(map);
        blogsWithConditions.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDynamic2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogsWithConditions = mapper.getBlogsWithId(Arrays.asList(1,2,3));
        blogsWithConditions.forEach(System.out::println);
        sqlSession.close();
    }
}
