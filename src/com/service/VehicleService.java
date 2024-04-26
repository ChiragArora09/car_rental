package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Vehicle;
import com.dao.VehicleDao;
import com.dao.VehicleDaoImpl;

public class VehicleService {
	
	VehicleDao dao = new VehicleDaoImpl();

	public List<Vehicle> getAllCars() throws SQLException {
		return dao.getAll();
	}

	public List<Vehicle> getAvailableCars() throws SQLException {
		return dao.getAllAvailable();
	}

	public int deleteVehicle(int id) throws SQLException {
		return dao.deleteVehicle(id);
	}
}
