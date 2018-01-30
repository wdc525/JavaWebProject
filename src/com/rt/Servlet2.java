package com.rt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response使用的码表，以控制response以什么码表向浏览器输出
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");

        String data = "中国人民";
        PrintWriter out = response.getWriter();
        out.write(data);
    }
}
