package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.utility.DBConnection;

public class UserDaolmpl implements UserDao {

	@Override
	public String save(User user) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO user(email_address, password, role, user_name) VALUES(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getEmail_address());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getRole());
		pstmt.setString(4, user.getUser_name());
		
		int status = pstmt.executeUpdate();
	
		DBConnection.dbClose();		
		
		if(status == 1) {
			return user.getEmail_address() + "  " + user.getRole();
		} else {
			return null;
		}
	}

	@Override
	public int getId(String email) throws SQLException {
		int user_id = -1;
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT id FROM user WHERE email_address='"+email+"'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet id = pstmt.executeQuery();
		while(id.next()) {
			user_id = id.getInt("id");
		}
		id.close();
		DBConnection.dbClose();
		return user_id;
	}	

}
