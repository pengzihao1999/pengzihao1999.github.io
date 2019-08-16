package cn.itcast.web;

import cn.itcast.service.Service;
import cn.itcast.service.Serviceimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Service s = new Serviceimp();
        s.deleteUser(id);
        request.getRequestDispatcher("/Servlet1").forward(request,response);
    }
}
