package com.rt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRefresh")
public class ServletRefresh extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "<meta http-equiv='refresh' content='3;url=/index.jsp'>恭喜你登陆成功，3秒后跳转到首页。如果没有跳转，请点<a href=''>超链接</a>";
        this.getServletContext().setAttribute("message",message);
        this.getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
    }
}

