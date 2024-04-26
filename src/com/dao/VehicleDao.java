package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Vehicle;

public interface VehicleDao {
	List<Vehicle> getAll() throws SQLException;
	List<Vehicle> getAllAvailable() throws SQLException;
	int deleteVehicle(int id) throws SQLException;
}