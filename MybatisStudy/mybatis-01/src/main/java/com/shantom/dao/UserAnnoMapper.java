package com.shantom.dao;

import com.shantom.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserAnnoMapper {
    @Select("select * from mybatis.user")
    List<User> getUserList();

    @Select("select * from user where name like #{name}")
    List<User> getUserLike(@Param("name") String name);

    @Select("select * from mybatis.user where id=#{id}")
    User getUserOne(@Param("id")int id);

    @Insert("insert into mybatis.user (id, name, pwd) value (#{id}, #{name}, ${pwd})")
    int insertUser(User user);

    @Delete("delete from mybatis.user where id=#{1}")
    int deleteUser(int id);

    @Update("update mybatis.user set name=#{name}, pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
}
