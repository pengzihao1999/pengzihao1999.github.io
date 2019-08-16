package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("服务器关闭....我被销毁了");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //判断是否进行登陆 如果没有登陆不放行，转发到登陆页面
        //如果已经登陆了,直接放行即可
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        if(request1.getSession().getAttribute("user")!=null){
            //说明登陆成功了
            //放行
            chain.doFilter(request1,response1);
            return;
        }else {
            //拦截
            //如果浏览器请求登陆相关的资源不拦截
            String url = ((HttpServletRequest) request).getRequestURI();
            System.out.println("url = " + url);
            if (url.contains("loginServlet") || url.contains("CodeServlet") || url.contains("login.jsp")) {
                chain.doFilter(request1, response1);
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request1, response1);

            }
        }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("登陆监听器开始工作了");
    }

}
