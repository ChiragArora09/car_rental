package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;
import com.model.Vehicle;

public interface CustomerDao {
	int save(Customer customer) throws SQLException;
	List<Vehicle> getAll() throws SQLException;
}
