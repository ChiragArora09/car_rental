package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;
import com.model.Vehicle;

public class CustomerService {
	CustomerDao dao = new CustomerDaoImpl();
	
	public int insert(Customer customer) throws SQLException {
		return dao.save(customer);
	}
	
	public List<Vehicle> getAllCars() throws SQLException {
		return dao.getAll();
	}
}
