package cn.itcast.cstm.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.runner.Request;

import cn.itcast.cstm.domain.Customer;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;

public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public void add(Customer c) {
		try {
			
			String sql = "insert into t_customer (cid,cname,gender,birthday,cellphone,email,description) values(?,?,?,?,?,?,?)";
			Object[] params = { c.getCid(), c.getCname(), c.getGender(),
					c.getBirthday(), c.getCellphone(), c.getEmail(),
					c.getDescription()};
			qr.update(sql, params);
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public List<Customer> findAll(){
		
		String sql = "select * from t_customer";
		try {
			return qr.query(sql,new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	public Customer load (String cid) {
		try{
		String sql = "select * from t_customer where cid=?";
		return qr.query(sql, new BeanHandler<Customer>(Customer.class), cid);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	public void edit(Customer c) {
		try {
			String sql = "update t_customer set cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? where cid=?";
			System.out.println(c.getCid());
			Object[] params = {c.getCname(), c.getGender(),
					c.getBirthday(), c.getCellphone(), c.getEmail(),
					c.getDescription(), c.getCid()};
			System.out.println(params);
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	public void delete(String cid) {
		try{
			String sql = "delete from t_customer where cid=?";
			qr.update(sql, cid);
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public List<Customer> query(Customer criteria) {
		try{
			System.out.println("进入DaO层了");
		StringBuilder sql = new StringBuilder("select * from t_customer where 1=1");
		
		List<Object> params = new ArrayList<Object>();
		String cname = criteria.getCname();
		if(cname != null && !cname.trim().isEmpty()){
			sql.append(" and cname like ?");
			params.add("%" + cname + "%");
		}
		
		String gender = criteria.getGender();
		if(gender != null && !gender.trim().isEmpty()){
			sql.append(" and gender=?");
			params.add(gender);
		}
		
		String cellphone = criteria.getCellphone();
		if(cellphone != null && !cellphone.trim().isEmpty()){
			sql.append(" and cellphone like ?");
			params.add("%" + cellphone + "%");
		}
		
		String email = criteria.getEmail();
		if(email != null && !email.trim().isEmpty()){
			sql.append(" and email like ?");
			params.add("%" + email + "%");
		}
		System.out.println(sql.toString());
		System.out.println(params.toString());
		return qr.query(sql.toString(),new BeanListHandler<Customer>(Customer.class), params.toArray());
	}catch (Exception e) {
		throw new RuntimeException(e);
	}
}
}
