package cn.itcast.web;

import cn.itcast.dao.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.Service;
import cn.itcast.service.Serviceimp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/fingPageByUserServlet")
public class fingPageByUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentpage = request.getParameter("currentpage");
        String rows = request.getParameter("rows");
        Service service = new Serviceimp();
        Map<String,String[]> condition  = (Map<String, String[]>) request.getParameterMap();
        request.setAttribute("condition",condition);
        PageBean<User> pageBean = service.fingPageByUser(currentpage,rows,condition);
        System.out.println(pageBean.toString());
        request.setAttribute("pg",pageBean);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentpage = request.getParameter("currentpage");
        String rows = request.getParameter("rows");
        Service service = new Serviceimp();
        Map<String,String[]> condition  = (Map<String, String[]>) request.getParameterMap();
        request.setAttribute("condition",condition);
        PageBean<User> pageBean = service.fingPageByUser(currentpage,rows,condition);
        System.out.println(pageBean.toString());
        request.setAttribute("pg",pageBean);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
