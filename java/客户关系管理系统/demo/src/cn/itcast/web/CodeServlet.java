package cn.itcast.web;

import cn.itcast.utils.VerifyCode;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        /*
         * 1. 创建验证码类
         */
        VerifyCode vc = new VerifyCode();
        /*
         * 2. 得到验证码图片
         */
        BufferedImage image = vc.getImage();
        /*
         * 3. 把图片上的文本保存到session中
         */
        request.getSession().setAttribute("session_vcode", vc.getText());
        /*
         * 4. 把图片响应给客户端
         */
        VerifyCode.output(image, response.getOutputStream());

    }
}