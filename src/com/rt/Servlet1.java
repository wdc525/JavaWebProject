package com.rt;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


public class Servlet1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        test3(response);
    }

    private void test3(HttpServletResponse response) throws IOException {
        String data = "中国";
        OutputStream out = response.getOutputStream();
        response.setContentType("text/html;charset=UTF-8");
        out.write(data.getBytes("utf-8"));
    }
    private void test2(HttpServletResponse response) throws IOException {
        String data = "中国";
        OutputStream out = response.getOutputStream();
        out.write("meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>".getBytes());
        out.write(data.getBytes("utf-8"));
    }
    private void test1(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type","text/html;charset=utf-8");
        String data = "中国";
        OutputStream out = response.getOutputStream();
        out.write(data.getBytes("utf-8"));
    }
}
