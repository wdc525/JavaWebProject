package com.rt;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ServletImage")
public class ServletImage extends HttpServlet {
    public static final int WIDTH=120;
    public static final int HEIGHT=25;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //内存中得到一副图像
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g= image.getGraphics();

        //1、设置背景
        setBackground(g);


        //2、设置边框

        setBorder(g);

        //3、画干扰线
        drawRadomLine(g);

        //4、写随机数
        drawRadomNum((Graphics2D) g);

        //5、写给浏览器

        //控制浏览器不要缓存
        response.setDateHeader("expries",-1);
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/jpeg");
        ImageIO.write(image,"jpg",response.getOutputStream());


    }

    private void drawRadomNum(Graphics2D g) {
        g.setColor(Color.red);
        g.setFont(new Font("宋体",Font.BOLD,20));
       int x=5;
        for (int i = 0; i < 4; i++) {
            String base = "\u4e00\u5566\u4e11\u8123\u4faa\u4e22\u5166\u5578";

            for (int j = 0; j < 4; j++) {
                int degree=new Random().nextInt()%30;

                String ch = base.charAt(new Random().nextInt(base.length()))+"";
                g.rotate(degree*Math.PI/180,x,20);
                g.drawString(ch,x,20);
                g.rotate(-degree*Math.PI/180,x,20);
                x=x+30;
                
            }

            
        }
    }

    private void drawRadomLine(Graphics g) {
        g.setColor(Color.blue);
        for (int i = 0; i < 5; i++) {
            int x1=new Random().nextInt(WIDTH);
            int y1=new Random().nextInt(HEIGHT);

            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1,y1,x2,y2);
            
        }
    }

    private void setBorder(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(1,1,WIDTH-2,HEIGHT-2);
    }

    private void setBackground(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }
}
