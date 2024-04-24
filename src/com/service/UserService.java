package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.dao.UserDaolmpl;
import com.model.User;

public class UserService {
	UserDao dao = new UserDaolmpl();
	
	public String insert(User user) throws SQLException {
		return dao.save(user);
	}
	
	public int getId(String email) throws SQLException {
		return dao.getId(email);
	}
	
}
