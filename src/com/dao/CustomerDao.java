package com.dao;

import java.sql.SQLException;

import com.model.Customer;

public interface CustomerDao {
	int save(Customer customer) throws SQLException;
}
