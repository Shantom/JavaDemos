package com.shantom.dao;

import com.shantom.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    @Insert("insert into mybatis.blog (id, title, author, create_time, views) value(#{id}, #{title}, #{author}, #{createTime}, #{views})")
    int insertBlog(Blog blog);

    List<Blog> getBlogsWithConditions(Map map);

    List<Blog> getBlogsWithId(List ids);

}
