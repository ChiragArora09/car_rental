package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ParticularVendorDto;
import com.dto.VendorProfitDto;
import com.model.Vendor;

public interface VendorDao {
	
	int save(Vendor vendor) throws SQLException;
	List<Vendor> getAllVendors() throws SQLException;
	ParticularVendorDto getParticularVendor(int id) throws SQLException;
	int blacklistVendor(int id) throws SQLException;
	int changeCommission(int id, double c) throws SQLException;
	List<VendorProfitDto> getProfits() throws SQLException;

}
