package com.shantom.hello.controller;


import com.shantom.hello.pojo.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg", "<h1>Hello, SpringBoot.</h1>");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("aa", 3));
        dogs.add(new Dog("bb", 4));
        model.addAttribute("dogs", dogs);
        return "hello";
    }
}
