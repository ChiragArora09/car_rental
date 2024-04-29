package com.service;

import com.dao.CustomerHistoryDao;
import com.dao.CustomerHistoryDaoImpl;
import com.model.CustomerHistory;

import java.sql.SQLException;
import java.util.List;


public class CustomerHistoryService {
	CustomerHistoryDao customerhistoryDao=new CustomerHistoryDaoImpl();

	public List<CustomerHistory> findAll(int id) throws SQLException {
		return customerhistoryDao.findAll(id);
	}
	
}
