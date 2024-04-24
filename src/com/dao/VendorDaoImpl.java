package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Vendor;
import com.utility.DBConnection;

public class VendorDaoImpl implements VendorDao {

	@Override
	public int save(Vendor vendor) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO vendor(name, identity_proof, phone_number, user_id) VALUES(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vendor.getName());
		pstmt.setString(2, vendor.getIdentity_proof());
		pstmt.setString(3, vendor.getPhone_number());
		pstmt.setInt(4, vendor.getUser_id());

		int status = pstmt.executeUpdate();
	
		DBConnection.dbClose();		
		return status;
	}

}
