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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    private Service service = new Serviceimp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> userList = service.findAll();
        //默认跳到第一页
        Service service = new Serviceimp();
        Map<String,String[]> condition = new HashMap<String, String[]>() ;
        PageBean<User> pageBean =  service.fingPageByUser("1","5",condition);
        request.setAttribute("pg",pageBean);

        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
