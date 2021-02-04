package com.shantom.managesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value ="/user/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        if(!name.isEmpty() && "123".equals(password)){
            session.setAttribute("loginUser", name);
            return "redirect:/main";
        }
        else {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }
}
