package com.shantom.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "D:\\GitProjects\\JavaWebStudy\\javaweb-02-servlet\\servlet-03-download\\src\\main\\resources\\down.png";
        String fileName = path.substring(path.lastIndexOf("\\")+1);
        FileInputStream is = new FileInputStream(path);
        ServletOutputStream outputStream = resp.getOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while((len = is.read(buffer))>0){
            outputStream.write(buffer, 0, len);
        }
        resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
        is.close();
        outputStream.close();
    }
}
