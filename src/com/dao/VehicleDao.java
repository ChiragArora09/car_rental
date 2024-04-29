package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.VehicleDto;
import com.exception.ResourceNotFoundException;
import com.model.Vehicle;

public interface VehicleDao {
	List<Vehicle> getAll() throws SQLException;
	List<Vehicle> getAllAvailable() throws SQLException;
	int deleteVehicle(int id) throws SQLException;
	int changeAvailabilityStatus(int vehicleId, int value) throws SQLException;
	
	/* ------------------------------------------------------------------------------- */
	
	int save(Vehicle vehicle) throws SQLException;
	Boolean findOne(int id) throws SQLException; 
	void deleteById(int id) throws SQLException,ResourceNotFoundException;
	List<Vehicle> findAll() throws SQLException;
	List<Vehicle> findAllfromVendor(int vendorId) throws SQLException;
	VehicleDto getAvgDailyRate(int vendorId) throws SQLException;
}