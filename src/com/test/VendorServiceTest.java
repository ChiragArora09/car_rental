package com.test;

import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

import com.model.Vendor;
import com.service.VendorService;

public class VendorServiceTest {
     VendorService VendorService= new VendorService();
     
     @Test
     public void testInsert() throws SQLException{
    	 Vendor newVendor=new Vendor("Gunther", "gunther_aadhar.pdf", "8923849032",3);
    	 int output= VendorService.insert(newVendor);
    	 int expectedOutput = 1;
    	 Assert.assertEquals(output, expectedOutput);
     }
     @Test
     public void testGetAllVendors() throws SQLException {
         // Test if the list of vendors is not null
         Assert.assertNotNull(VendorService.getAllVendors());
     }

     @Test
     public void testGetVendorById() throws SQLException {
         // Assuming vendor with ID 1 exists in the database
         int existingVendorId = 1;
         Assert.assertNotNull(VendorService.getVendorById(existingVendorId));
     }

     @Test
     public void testBlockVendor() throws SQLException {
         // Assuming vendor with ID 1 exists in the database
         int existingVendorId = 1;
         int output = VendorService.blockVendor(existingVendorId);
         int expectedOutput = 1; // Assuming 1 indicates successful blocking
         Assert.assertEquals(output, expectedOutput);
     }

     @Test
     public void testChangeCommission() throws SQLException {
         // Assuming vendor with ID 1 exists in the database
         int existingVendorId = 1;
         double newCommission = 5.0; // Assuming the new commission to be set
         int output = VendorService.changeCommission(existingVendorId, newCommission);
         int expectedOutput = 1; // Assuming 1 indicates successful commission change
         Assert.assertEquals(output, expectedOutput);
     }
}
