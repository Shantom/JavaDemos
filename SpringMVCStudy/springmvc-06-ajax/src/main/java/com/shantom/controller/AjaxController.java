package com.shantom.controller;

import com.shantom.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("a1")
    public void getAjax(String name, HttpServletResponse response) throws IOException {
        response.getWriter().println(name);
    }

    @RequestMapping("a2")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"dd", 2));
        users.add(new User(2,"aa", 23));
        users.add(new User(3,"bb", 222));

        return users;
    }
}
