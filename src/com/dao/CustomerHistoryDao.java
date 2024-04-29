package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.CustomerHistory;

public interface CustomerHistoryDao {
	List<CustomerHistory> findAll(int id) throws SQLException;
}
