package com.shantom.managesystem.dao;

import com.shantom.managesystem.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static final Map<Integer, User> users;

    static {
        users = new HashMap<>();
        users.put(1, new User(1, "AA", true, new Date()));
        users.put(2, new User(2, "BB", false, new Date()));
        users.put(3, new User(3, "CC", false, new Date()));
        users.put(4, new User(4, "DD", true, new Date()));
    }


    private Collection<User> getAllUsers(){
        return users.values();
    }

    private User getUserById(int id){
        return users.get(id);
    }


}
