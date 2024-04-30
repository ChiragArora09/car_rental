package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerHistoryDto;
import com.model.CustomerHistory;
import com.model.Lease;

public interface CustomerHistoryDao {
	List<CustomerHistoryDto> findAll(int id) throws SQLException;
	List<Lease> GetOngoingDeals(int id) throws SQLException;
	List<Lease> GetPendingDeals(int id) throws SQLException;
	int insertIntoHistory(CustomerHistory customerHistory) throws SQLException;
}
