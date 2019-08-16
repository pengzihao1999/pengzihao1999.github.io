package test.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.book.domain.Book;
import test.book.service.BookException;
import test.book.service.BookService;
import cn.itcast.commons.CommonUtils;

public class DelectServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   BookService bs=new BookService();
		   request.setCharacterEncoding("utf-8");
		   response.setContentType("text/html;charset=utf-8");
		   Book form1=CommonUtils.toBean(request.getParameterMap(), Book.class);
		   if(form1.getBookID()==null)
		   {
			 
			   request.setAttribute("msg", "书的ID号不能为空啊！！");
		       request.getRequestDispatcher("/Book/delectbook.jsp").forward(request, response);
		       return ;
		   }
		   try
		   {
			   bs.delectbook(form1);
			   response.sendRedirect(request.getContextPath()+"/Book/success3.jsp");
		   }
		   catch (BookException e) {
			   
			   request.setAttribute("msg", e.getMessage());
		       request.getRequestDispatcher("/Book/delectbook.jsp").forward(request, response);
		}   
	}
}
