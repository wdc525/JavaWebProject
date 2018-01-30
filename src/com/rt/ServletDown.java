package com.rt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet(name = "ServletDown")
public class ServletDown extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=this.getServletContext().getRealPath("/download/下载图.jpg");
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        System.out.println("aaa:"+path);
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename,"utf-8"));
        InputStream in =null;
        OutputStream out=null;

        in = new FileInputStream(path);
        int len=0;
        byte buffer[] = new byte[1024];
        out = response.getOutputStream();
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }



    }
}
