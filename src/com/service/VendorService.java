package com.service;

import java.sql.SQLException;

import com.dao.VendorDao;
import com.dao.VendorDaoImpl;
import com.model.Vendor;

public class VendorService {
	VendorDao dao = new VendorDaoImpl();
	
	public int insert(Vendor vendor) throws SQLException {
		return dao.save(vendor);
	}

}
