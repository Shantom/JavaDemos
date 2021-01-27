package com.shantom.mapper;

import com.shantom.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    int addUser(User user);

    int delUser(int id);
}
