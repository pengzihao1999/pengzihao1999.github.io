package demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*设置响应流编码和浏览器解析的编码 一个顶两
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("It is Ok,彭子豪");*/
//		response.setStatus(302);
//		response.setHeader("Location", "https://www.baidu.com");
		/* 要加项目名，因为是重定向是客户端路径
		response.sendRedirect("/xixihaha/Aservlet");
		*/
		String Appl = request.getContextPath();
		StringBuffer URL = request.getRequestURL();
		String URI = request.getRequestURI();
		String servlet  = request.getServletPath();
		String query  =  request.getQueryString();
		System.out.println(Appl+","+URI+ ","+URL+","+servlet+","+query);
		String name = request.getParameter("name");
		System.out.println(name);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
