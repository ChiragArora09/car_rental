package com.service;

import com.dao.CustomerHistoryDao;
import com.dao.CustomerHistoryDaoImpl;
import com.dto.CustomerHistoryDto;
import com.model.CustomerHistory;
import com.model.Lease;

import java.sql.SQLException;
import java.util.List;


public class CustomerHistoryService {
	CustomerHistoryDao customerhistoryDao=new CustomerHistoryDaoImpl();

	public List<CustomerHistoryDto> findAll(int id) throws SQLException {
		return customerhistoryDao.findAll(id);
	}
	
	public List<Lease> GetOngoingDeals(int id) throws SQLException {
		return customerhistoryDao.GetOngoingDeals(id);
	}
	
	public List<Lease> GetPendingDeals(int id) throws SQLException {
		return customerhistoryDao.GetPendingDeals(id);
	}

	public int insertIntoHistory(CustomerHistory customerHistory) throws SQLException{
		return customerhistoryDao.insertIntoHistory(customerHistory);
	}

	
}
