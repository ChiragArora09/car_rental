package com.dao;

import java.sql.SQLException;

import com.model.User;

public interface UserDao {
	String save(User user) throws SQLException;
	int getId(String email) throws SQLException;
	User login(String username, String password) throws SQLException;
}
