package cn.itcast.cstm.service;

import java.util.List;

import cn.itcast.cstm.dao.CustomerDao;
import cn.itcast.cstm.domain.Customer;

public class CustomerService {
	private CustomerDao customerdao = new CustomerDao();

	public void add(Customer c){
		System.out.println("ha1");
		customerdao.add(c);
	}
	public List<Customer> findAll()
	{
		return customerdao.findAll();
	}
	public Customer load(String cid) {
		return customerdao.load(cid);
	}
	public void edit(Customer c) {
		customerdao.edit(c);
		
	}
	public void delete(String cid) {
		customerdao.delete(cid);
	}
	public List<Customer> query(Customer criteria) {
		System.out.println("进入query层了");
		return customerdao.query(criteria);
	}
}
