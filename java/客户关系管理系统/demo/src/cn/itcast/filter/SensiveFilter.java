package cn.itcast.filter;

import org.junit.Test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensiveFilter implements Filter {
    public void destroy() {
    }
    private List<String> sensetivelist = new ArrayList<>();
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*
            实现敏感词过滤功能，运用动态代理模式
         */

        ServletRequest Pro_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getParameter")){
                    //如果方法的名称是getParameter
                    //获取方法的返回值
                    String value = (String) method.invoke(req,args);
                    if(value==null) return value;
                    for(String str:sensetivelist){
                        if(value.contains(str)){
                            value = value.replaceAll(str,"***");
                        }
                    }
                    System.out.println("value = " + value);
                return value;
                }
                return method.invoke(req,args);
            }
        });

        chain.doFilter(Pro_req, resp);
    }
    public void init(FilterConfig config) throws ServletException {
            //进行初始化
        String path = config.getServletContext().getRealPath("/WEB-INF/classes/words.txt");
        System.out.println("path = " + path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                sensetivelist.add(line);
            }
            System.out.println("sensetivelist = " + sensetivelist.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
