package com.shantom.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean con2 = request.getRequestURL().toString().contains("goLogin");
        boolean con3 = request.getRequestURL().toString().contains("login");

        String user = (String) request.getSession().getAttribute("user");
        if(con2||con3|| user!=null){
            return true;
        }
        else {
            System.out.println(request.getRequestURL().toString());
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return false;
        }
    }
}
