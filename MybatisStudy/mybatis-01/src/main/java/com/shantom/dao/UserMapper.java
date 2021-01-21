package com.shantom.dao;

import com.shantom.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLike(String name);

    User getUserOne(int id);

    int insertUser(User user);

    int deleteUser(int id);

    int updateUser(User user);
}
