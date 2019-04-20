package test.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;

import test.book.domain.Book;
import test.book.service.BookException;
import test.book.service.BookService;
import cn.itcast.commons.CommonUtils;

public class AddServlet extends HttpServlet {

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
        Map<String,String>errors=new HashMap<String,String>();	
		if(form1.getBookID().trim().isEmpty())
		{
            errors.put("bookID", "书的ID号不能为空");
		}
		if(form1.getAuthor().trim().isEmpty())
		{
            errors.put("author", "书的作者不能为空");
		}
		if(form1.getBookname().trim().isEmpty())
		{
            errors.put("bookname", "书的名字不能为空");
		}
		if(form1.getPulishedlocation().trim().isEmpty())
		{
            errors.put("pulishedlocation", "书的出版社不能为空");
		}
		if(form1.getPrice()==0)
		{
            errors.put("price", "书的价格不能为空");
		}
	    if(errors.size()>0)
	    { 
	    	request.setAttribute("wrong",errors);
	    	request.setAttribute("book", form1);
	    	request.getRequestDispatcher("/Book/add.jsp").forward(request, response);
	        return;
	    }
	    if(!request.getParameter("verifycode").equalsIgnoreCase( (String) request.getSession().getAttribute("session_vcode")))
	    {
	    	request.setAttribute("msgs", "验证码错误");
	    	request.setAttribute("book", form1);
	    	request.getRequestDispatcher("/Book/add.jsp").forward(request, response);
	        return;
	    }
	    	try {
			bs.add(form1);
			response.sendRedirect(request.getContextPath()+"/Book/success2.jsp");
		} catch (BookException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("book", form1);
			request.getRequestDispatcher("/Book/add.jsp").forward(request, response);
		}
	    
	    
	}

}
