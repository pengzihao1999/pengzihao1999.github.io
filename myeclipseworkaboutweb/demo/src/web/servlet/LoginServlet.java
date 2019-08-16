package cn.itcast.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;

/**
 * UserServlet层
 * @author cxf
 *
 */
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//请求编码(POST)
		response.setContentType("text/html;charset=utf-8");//响应编码
		
		// 依赖UserService
		UserService userService = new UserService();
		
		/*
		 * 1. 封装表单数据到User form中
		 * 2. 调用service的login()方法，得到返回的User user对象。
		 *   > 如果抛出异常：获取异常信息，保存到request域，再保存form，转发到login.jsp
		 *   > 如果没有异常：保存返回值到session中，重定向到welcome.jsp
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("sessionUser", user);
			response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
		} catch(UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
		
	}
}
