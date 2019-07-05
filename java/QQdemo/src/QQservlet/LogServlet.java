package QQservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import QQdomain.User;
import QQservice.QQservice;

public class LogServlet extends HttpServlet {
	private QQservice qqservice = new QQservice();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ID = request.getQueryString();
		//加载这个ID用户的所有的朋友圈列表显示在网页上
	
		ArrayList<User> userlist = qqservice.load(ID);
		
		HttpSession ss=  request.getSession();
		ss.setAttribute("userlist", userlist);
		request.setAttribute("myid", ID);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
	}

}
