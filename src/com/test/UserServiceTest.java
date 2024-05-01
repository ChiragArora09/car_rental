package com.test;

import com.model.User;
import com.service.UserService;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
	UserService userService = new UserService();
	
@Test
public void testInsert() throws SQLException {
	User user = new User("example@email.com", "12345678", "Vendor", "example");
	String output = userService.insert(user);
	String expectedOutput = "example@email.com  Vendor";
	Assert.assertEquals(expectedOutput, output);
}

}