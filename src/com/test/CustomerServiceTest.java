package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Customer;
import com.service.CustomerService;

public class CustomerServiceTest {
CustomerService customerService = new CustomerService();

	@Test
	public void testBlackList() throws SQLException{
		int status = customerService.blacklistCustomer(1);
		int expectedOutput = 1;
		Assert.assertEquals(expectedOutput, status);
	}
	
	@Test
	public void testgetAllCustomer() throws SQLException{
		List<Customer> list = customerService.getAllCustomers();
		List<Customer> expectedList = new ArrayList<>();
		Customer a = new Customer(1, "Chirag", "Arora", "9826340129", "Bhopal",1,"ASD2342092");
		expectedList.add(a);
		
		Assert.assertEquals(expectedList.size(), list.size());
		
		  for(int i = 0; i < expectedList.size(); i++) {
			    Customer expectedCustomer = expectedList.get(i);
			    Customer actualCustomer = list.get(i);
			    Assert.assertEquals(expectedCustomer.getId(), actualCustomer.getId());
			    Assert.assertEquals(expectedCustomer.getFirst_name(), actualCustomer.getFirst_name());
			    Assert.assertEquals(expectedCustomer.getLast_name(), actualCustomer.getLast_name());
			  }
		}
	
    @Test
    public void testGetAllCustomers() throws SQLException {
        List<Customer> customers = customerService.getAllCustomers();
        Assert.assertNotNull(customers);
        Assert.assertFalse(customers.isEmpty());
    }
    
    @Test
    public void testInsert() throws SQLException{
    Customer newCustomer = new Customer("esha", "gupta", "78756444","Bhopal",3,"DL1234456");
	   int output= customerService.insert(newCustomer);
	   int expectedOutput = 1;
	   Assert.assertEquals(output, expectedOutput);
    }
	
}
