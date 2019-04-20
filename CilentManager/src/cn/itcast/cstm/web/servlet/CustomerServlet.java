package cn.itcast.cstm.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMStateSet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.cstm.domain.Customer;
import cn.itcast.cstm.service.CustomerService;
import cn.itcast.servlet.BaseServlet;

public class CustomerServlet extends BaseServlet {

	private CustomerService customerService = new CustomerService();
  
	public String add (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		c.setCid(CommonUtils.uuid());
		try{
		customerService.add(c);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("jaja");
		request.setAttribute("msg", "恭喜，添加客户成功");
		return "f:/msg.jsp";//转发
	}
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cstmList", customerService.findAll());
		return "f:/list.jsp";
		
	}
	
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		Customer cstm = customerService.load(cid);
		request.setAttribute("cstm", cstm);
		return "f:/edit.jsp";
	}
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(c);
		request.setAttribute("msg", "恭喜，编辑成功");
		return "f:/msg.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		customerService.delete(cid);
		request.setAttribute("msg", "删除成功");
		return "f:/msg.jsp";
	}
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入Servlet层了");
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		List<Customer> cstmList = customerService.query(criteria);
		request.setAttribute("cstmList",cstmList);
		return "f:/list.jsp";
	}
}
