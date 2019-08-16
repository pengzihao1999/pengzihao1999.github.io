package cn.itcast.web;

import cn.itcast.domain.User;
import cn.itcast.service.Service;
import cn.itcast.service.Serviceimp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        try {
            String str = request.getParameter("verifycode");
            if(!str.equals(request.getSession().getAttribute("session_vcode"))){
                //验证码错误
                request.setAttribute("msg","验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
            User user = new User();
            BeanUtils.populate(user,request.getParameterMap());
            Service service =  new Serviceimp();
            User user1 = service.Login(user);
            if(user1==null){
                request.setAttribute("msg","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
            request.getSession().setAttribute("user",user1);
            response.sendRedirect(request.getContextPath()+"/Servlet1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
