package com.shantom.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();

        long time = 0;
        for (Cookie cookie : cookies) {
            if("lastLoginDate".equals(cookie.getName())){
                String value = cookie.getValue();
                time = Long.parseLong(value);
                break;
            }
        }

        if(time==0){
            writer.println("第一次访问");
        }else {
            Date date = new Date(time);
            String s = date.toLocaleString();
            writer.println("上次访问时间:"+s);
        }

        resp.addCookie(new Cookie("lastLoginDate", System.currentTimeMillis()+""));

    }
}
