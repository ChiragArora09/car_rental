package com.test;

import java.sql.SQLException;


import org.junit.Assert;
import org.junit.Test;

import com.model.Vehicle;
import com.service.VehicleService;

public class VehicleServiceTest {
VehicleService vehicleService = new VehicleService();

@Test
public void testInsert() throws SQLException{
	
    Vehicle newVehicle = new Vehicle(70, "MS Swift", "2023", "2023-05-10", 1200, 1, 5, "1997cc", 1);

    int status = vehicleService.insertWithID(newVehicle);
    Vehicle insertedVehicle = vehicleService.getVehicleById(70);
    Assert.assertNotNull(insertedVehicle);
  
   // System.out.println(insertedVehicle.getVehicle_name());
    String ExpectedValue = "MS Swift";
    String ActualValue = insertedVehicle.getVehicle_name();
    Assert.assertEquals(ExpectedValue, ActualValue);
}
}
