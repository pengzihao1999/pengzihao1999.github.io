package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter{
	//


	public void destroy() {
		System.out.println("Filter被销毁");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("filter开始拦截了");
	}

	public void init(FilterConfig arg0) throws ServletException {
	System.out.println("Filter被创建");
	}

}
