package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dao.CustomerHistoryDao;
import com.dao.CustomerHistoryDaoImpl;
import com.exception.NewCustomerException;

public class CustomerHistoryTest {
	CustomerHistoryDao dao=new CustomerHistoryDaoImpl();
	//test case 1
	 @Test
	    public void testGetTotalMileageByCustomerId() throws Exception {
	        // Arrange
	        int customerId = 4; // Existing customer ID in your database

	        // Act
	        int totalMileage = dao.GetTotalMileageById(customerId);
	        int expectedTotalMileage=300;
	        // Assert
	        // Add your assertions here to verify the expected total mileage
	        // For example:
	        assertEquals(expectedTotalMileage, totalMileage);
	    }
	 //test case 2
	 @Test
	    public void testGetTotalMileageByCustomerId1() throws Exception {
	        // Arrange
	        int customerId = 5; // Existing customer ID in your database

	        // Act
	        int totalMileage = dao.GetTotalMileageById(customerId);
	        int expectedTotalMileage=200;
	        // Assert
	        // Add your assertions here to verify the expected total mileage
	        // For example:
	        assertEquals(expectedTotalMileage, totalMileage);
	    }
	 //test case 3
	 @Test
	    public void testGetTotalMileageByCustomerId2() throws Exception {
	        // Arrange
	        int customerId = 11; // Existing customer ID in your database

	        // Act
	        int totalMileage = dao.GetTotalMileageById(customerId);
	        int expectedTotalMileage=602;
	        // Assert
	        // Add your assertions here to verify the expected total mileage
	        // For example:
	        assertEquals(expectedTotalMileage, totalMileage);
	    }
	    //test case 4
	 //test case 3
	 @Test
	    public void testGetTotalMileageByCustomerId3() throws Exception {
	        // Arrange
	        int customerId = 12; // Existing customer ID in your database

	        // Act
	        int totalMileage = dao.GetTotalMileageById(customerId);
	        int expectedTotalMileage=689;
	        // Assert
	        // Add your assertions here to verify the expected total mileage
	        // For example:
	        assertEquals(expectedTotalMileage, totalMileage);
	    }

	 // test case 5
	    @Test(expected = NewCustomerException.class)
	    public void testGetTotalMileageById_NewCustomer() throws Exception {
	        // Arrange
	        int customerId =999; // Non-existing customer ID in your database

	        // Act
	        dao.GetTotalMileageById(customerId);

	        // Assert
	        // This test expects a NewCustomerException to be thrown
	    }

	    
	    //test case 6
	    @Test(expected = NewCustomerException.class)
	    public void testGetTotalMileageById_NewCustomer1() throws Exception {
	        // Arrange
	        int customerId =2; // Non-existing customer ID in your database

	        // Act
	        dao.GetTotalMileageById(customerId);

	        // Assert
	        // This test expects a NewCustomerException to be thrown
	    }

	    }