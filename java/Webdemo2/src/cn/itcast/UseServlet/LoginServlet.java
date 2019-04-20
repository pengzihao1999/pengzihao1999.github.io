package cn.itcast.UseServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.Service.UserException;
import cn.itcast.Service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.domain.User;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
	    UserService userService=new UserService();
	     /*
	      * 1封装表单数据到user form中
	      * 2.调用Service的login方法 得到
	      */
	    User form =CommonUtils.toBean(request.getParameterMap(), User.class);
	    try
	    {
	    	User user=userService.login(form);
	    	
	    }
	    catch(UserException e)
	    {
	    	request.setAttribute("msg",e.getMessage() );
	    	request.setAttribute("user", form);
	    	request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	    }
	}
}
