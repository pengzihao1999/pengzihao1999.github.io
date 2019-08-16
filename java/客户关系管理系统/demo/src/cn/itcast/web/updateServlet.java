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

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            Service s = new Serviceimp();
            s.update(user);
            //添加成功
            //转发到Servlet1显示更新后的结果
            response.sendRedirect(request.getContextPath() + "/Servlet1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

