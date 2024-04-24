package com.dao;

import java.sql.SQLException;

import com.model.Vendor;

public interface VendorDao {
	int save(Vendor vendor) throws SQLException;

}
