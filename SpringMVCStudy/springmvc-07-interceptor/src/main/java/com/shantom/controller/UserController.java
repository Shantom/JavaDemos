package com.shantom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String name, String password){
        HttpSession session = request.getSession();
        session.setAttribute("user", name);
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "login";
    }


}
