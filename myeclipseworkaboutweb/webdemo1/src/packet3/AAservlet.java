package packet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AAservlet extends HttpServlet {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	        String str=   request.getParameter("num1");
	        String str2=request.getParameter("num2");
	        int  in1=Integer.parseInt(str);
	        int  in2=Integer.parseInt(str2);
	        int  result=in1+in2;
	        request.setAttribute("result", result);
	        request.getRequestDispatcher("/sumjsps/result.jsp").forward(request, response);
	           
	}

}
