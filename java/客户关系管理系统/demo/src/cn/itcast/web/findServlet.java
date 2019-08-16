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

@WebServlet("/findServlet")
public class findServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Serviceimp();
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());

            User user1 = service.findUser(user);
            //回显到界面

            request.setAttribute("user",user1);
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
