package cn.itcast.UseServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.Service.UserException;
import cn.itcast.Service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.domain.User;

public class RegistServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       
       UserService userService=new UserService();
       
       User form=CommonUtils.toBean(request.getParameterMap(), User.class);
       
       Map<String,String > errors=new HashMap<String,String>();
       
       String username=form.getUsername();
       System.out.println(username);
       if(username==null||username.trim().isEmpty()){
    	errors.put("username", "用户名不能为空");
       }
       else if(username.length()<3||username.length()>15)
       {
    	   errors.put("username", "用户名必须在3——15之间");   
       }
       
		String password = form.getPassword();
		System.out.println(password);
		if(password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if(password.length() < 3 || password.length() > 15) {
			errors.put("password", "密码长度必须在3~15之间！");
		}
		String sessionVerfycode=(String)request.getSession().getAttribute("session_vcode");
		String verifycode=form.getVerifycode();
		System.out.println(verifycode);
		if(verifycode==null||verifycode.trim().isEmpty())
		{
		 errors.put("verifyCode", "验证码不能为空");
		}
		else if(!verifycode.equalsIgnoreCase(sessionVerfycode))
		{
			errors.put("verifyCode", "验证码错误");
		}
		
		if(errors!=null&&errors.size()>0)
		{
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			return ;
		}
		
		try {
			userService.regist(form);
			response.getWriter().print("<h1>注册成功！</h1> )<a href='"+
			request.getContextPath()+"/user/login.jsp"+"'>点击这里去登录</a>");
		} catch (UserException e) {
		    
			request.setAttribute("msg", e.getMessage());
			
			request.setAttribute("user", form);
			
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			
		}
       
	
	}
}
