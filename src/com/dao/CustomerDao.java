package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;
import com.model.Vehicle;

public interface CustomerDao {
	int save(Customer customer) throws SQLException;
	Customer getCustomer(int id) throws SQLException;
	Customer particularCustomer(int id) throws SQLException;
	List<Customer> getAllCustomers() throws SQLException;
	int blacklistCustomer(int id) throws SQLException;
}
