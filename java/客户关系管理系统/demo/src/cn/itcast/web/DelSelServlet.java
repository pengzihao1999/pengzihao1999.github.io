package cn.itcast.web;

import cn.itcast.service.Service;
import cn.itcast.service.Serviceimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelSelServlet")
public class DelSelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String[] strs = request.getParameterValues("uid");
        Service service = new Serviceimp();
        for(String id:strs){
            service.deleteUser(id);
        }
        request.getRequestDispatcher("/Servlet1").forward(request,response);
    }

}
