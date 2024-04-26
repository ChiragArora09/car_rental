package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Lease;
import com.dao.LeaseDao;
import com.dao.LeaseDaoImpl;
import com.dto.BookingDto;

public class LeaseService {
	
	LeaseDao dao = new LeaseDaoImpl();
	
	public int bookVehicle(Lease lease) throws SQLException {
		return dao.insertIntoLease(lease);
	}
	
	public List<BookingDto> getAllBookings() throws SQLException {
		return dao.getAllLeases();
	}

}
