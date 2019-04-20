package logintest;

import java.io.IOException;
import java.io.PrintWriter;
/*
 * 步骤 一 新建一个方法为post的表单 提交路径为LoginServlet
 * 步骤 二 
 *         ①通过LoginServlet通过提交的参数来获取提交的值 
 *         ②进行判断用户名和密码是否正确
 *           --若正确 保存用户名密码到session域 然后重定向 succ1.jsp页面 显示用户名信息
 *           --若错误 通过request域转发到登陆页面 并显示在form.jap上显示登陆失败信息
 * 步骤 三  在succ1中，若session域的值不为空，就显示session域中的值
 *                  若session域的值为空，就通过request请求重定向到form.jsp  
 */

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSevlet extends HttpServlet {
	/*
	 * 实现看不清换一张功能
	 * 1.通过引入一个超链接继续访问ImageServlet生成其余随机的图片
	 * 2.怎么做呢？可以通过js绑定超链接点击事件来完成
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String str=(String)request.getParameter("code");
        if(!str.equalsIgnoreCase((String)request.getSession().getAttribute("codetest")))
		{
			request.setAttribute("msg", "验证码输入错误请重新输入");
			request.getRequestDispatcher("/logintest/form.jsp").forward(request, response);
			return;
		}
        if(name.equals("pengzihao"))
        {
        	request.getSession().setAttribute("username", name);
            Cookie cookie=new Cookie("uname",name);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        	response.sendRedirect("/webdemo1/logintest/succ1.jsp");
        	
        }
        else
        {
          request.setAttribute("msg", "你的密码或用户名错了");
          request.getRequestDispatcher("/logintest/form.jsp").forward(request, response);
          
        }
      
		
	}

}
