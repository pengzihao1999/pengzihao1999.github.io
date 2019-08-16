package listenerintecept.mylistener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public class Listener implements ServletContextListener {
	/*
	 * 步骤:ServletContextListener的生命周期方法init()在服务器创建时会被调用
	 * 1.我们可以在init()中来创建一个map用来保存客户访问的Ip和访问次数count。
	 * 2.保存map到ServletContext域中	 
	 */
    public void contextInitialized(ServletContextEvent arg0) {
    	System.out.println("listener被初始化");
    	Map<String,Integer> map = new LinkedHashMap<String,Integer>();
    	ServletContext application = arg0.getServletContext();
    	application.setAttribute("map", map);
    }
    public void contextDestroyed(ServletContextEvent arg0) {
  
    }
}
