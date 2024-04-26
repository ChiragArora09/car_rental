package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.BookingDto;
import com.model.Lease;

public interface LeaseDao {
	public int insertIntoLease(Lease lease) throws SQLException;

	public List<BookingDto> getAllLeases() throws SQLException;
}
