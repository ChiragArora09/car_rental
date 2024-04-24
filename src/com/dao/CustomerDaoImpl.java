package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Customer;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public int save(Customer customer) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO customer(first_name, last_name, phone_number, city, user_id, driving_license) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customer.getFirst_name());
		pstmt.setString(2, customer.getLast_name());
		pstmt.setString(3, customer.getPhone_number());
		pstmt.setString(4, customer.getCity());
		pstmt.setInt(5, customer.getUser_id());
		pstmt.setString(6, customer.getDriving_license());
		
		int status = pstmt.executeUpdate();
	
		DBConnection.dbClose();		
		return status;
	}

}
