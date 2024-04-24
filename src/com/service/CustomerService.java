package com.service;

import java.sql.SQLException;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;

public class CustomerService {
	CustomerDao dao = new CustomerDaoImpl();
	
	public int insert(Customer customer) throws SQLException {
		return dao.save(customer);
	}
}
