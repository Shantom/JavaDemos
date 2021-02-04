package com.shantom.managesystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("loginUser");
        if(name!=null){
            return true;
        }else {
            request.setAttribute("msg", "请先登陆");
            System.out.println(request.getRequestURI());
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
    }
}
