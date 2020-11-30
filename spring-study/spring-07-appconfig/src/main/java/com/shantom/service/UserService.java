package com.shantom.service;

import com.shantom.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {

    @Bean
    public User user(){
        return new User();
    }
}
