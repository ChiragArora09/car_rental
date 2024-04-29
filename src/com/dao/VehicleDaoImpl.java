package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.VehicleDto;
import com.exception.ResourceNotFoundException;
import com.model.Vehicle;
import com.utility.DBConnection;

public class VehicleDaoImpl implements VehicleDao {

	@Override
	public List<Vehicle> getAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from vehicle";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Vehicle> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			String vehicle_name = rst.getString("vehicle_name");
			String vehicle_model = rst.getString("vehicle_model");
			String vehicle_year = rst.getString("vehicle_year");
			float daily_rate = rst.getFloat("daily_rate");
			int availability_status = rst.getInt("availability_status");			
			int passenger_capacity = rst.getInt("passenger_capacity");
			String engine_capacity = rst.getString("engine_capacity");
			int vendor_id = rst.getInt("vendor_id");
			
			Vehicle v1 = new Vehicle(id, vehicle_name, vehicle_model, vehicle_year, daily_rate, availability_status, passenger_capacity, engine_capacity, vendor_id);
			list.add(v1);
		}
		
		DBConnection.dbClose();
		
		return list;
	}

	@Override
	public List<Vehicle> getAllAvailable() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from vehicle WHERE availability_status=1 AND vendor_active=1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Vehicle> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			String vehicle_name = rst.getString("vehicle_name");
			String vehicle_model = rst.getString("vehicle_model");
			String vehicle_year = rst.getString("vehicle_year");
			float daily_rate = rst.getFloat("daily_rate");
			int availability_status = rst.getInt("availability_status");			
			int passenger_capacity = rst.getInt("passenger_capacity");
			String engine_capacity = rst.getString("engine_capacity");
			int vendor_id = rst.getInt("vendor_id");
			
			Vehicle v1 = new Vehicle(id, vehicle_name, vehicle_model, vehicle_year, daily_rate, availability_status, passenger_capacity, engine_capacity, vendor_id);
			list.add(v1);
		}
		
		DBConnection.dbClose();
		
		return list;
	}

	@Override
	public int deleteVehicle(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE vehicle SET vendor_active=0 WHERE vendor_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public int changeAvailabilityStatus(int vehicleId, int value) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE vehicle SET availability_status=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, value);
		pstmt.setInt(2, vehicleId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();		
		return status;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public int save(Vehicle vehicle) throws SQLException {
		// insert artist record in DB
				Connection con = DBConnection.dbConnect();
				String sql="INSERT INTO Vehicle (vehicle_name , vehicle_model, vehicle_year, daily_rate, availability_status, passenger_capacity, engine_capacity, vendor_id) VALUES (?,?,?,?,?,?,?,?)";
				//prepare the statement 
				PreparedStatement pstmt = con.prepareStatement(sql);
				//attach the data
				pstmt.setString(1, vehicle.getVehicle_name());
				pstmt.setString(2, vehicle.getVehicle_model());
				pstmt.setString(3, vehicle.getVehicle_year());
				pstmt.setDouble(4, vehicle.getDaily_rate());
				pstmt.setInt(5, vehicle.getAvailability_status());
				pstmt.setInt(6, vehicle.getPassenger_capacity());
				pstmt.setString(7, vehicle.getEngine_capacity());
				pstmt.setInt(8, vehicle.getVendor_id());
				//execute the query 
				int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
				DBConnection.dbClose();
				return status;
	}

	@Override
	public Boolean findOne(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select id from vehicle where id=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst  = pstmt.executeQuery();
		boolean status = rst.next(); //true / false
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void deleteById(int id) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="delete from vehicle where id =?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}
	
	@Override
	public List<Vehicle> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from vehicle";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Vehicle> list = new ArrayList<>();
		while(rst.next() == true) {
			
			int id  = rst.getInt("id");
			String vehicleName= rst.getString("vehicle_name");
			String vehicleModel= rst.getString("vehicle_model");;
			String vehicleYear= rst.getString("vehicle_year");;
			float dailyRate= rst.getFloat("daily_rate");
			int availabilityStatus= rst.getInt("availability_status");
			int passengerCapacity= rst.getInt("passenger_capacity");
			String engineCapacity= rst.getString("engine_capacity");;
			int vendorId = rst.getInt("vendor_id");;
			
			Vehicle vehicle = new Vehicle(id, vehicleName, vehicleModel, vehicleYear, dailyRate, availabilityStatus, passengerCapacity, engineCapacity, vendorId);
			
			list.add(vehicle);
		}
		DBConnection.dbClose();		
		return list;
	}
	
	@Override
	public VehicleDto getAvgDailyRate(int vendorId) throws SQLException {
	    Connection con = DBConnection.dbConnect();
	    String sql = "SELECT v.vendor_id, AVG(v.daily_rate) AS average_daily_rate " +
	                 "FROM car_rental.vehicle v " +
	                 "WHERE v.vendor_id = ? " +
	                 "GROUP BY v.vendor_id";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setInt(1, vendorId);

	    ResultSet rst = pstmt.executeQuery();
	    VehicleDto vehicleDto = new VehicleDto(); 

	    if (rst.next()) {
	        double averageDailyRate = rst.getDouble("average_daily_rate");
	        vehicleDto.setValue(averageDailyRate);
	    }

	    DBConnection.dbClose();     
	    return vehicleDto;
	}

	@Override
	public List<Vehicle> findAllfromVendor(int vendorId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from vehicle where vendor_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, vendorId);
		ResultSet rst = pstmt.executeQuery();
		List<Vehicle> list = new ArrayList<>();
		while(rst.next() == true) {
			
			int id  = rst.getInt("id");
			String vehicleName= rst.getString("vehicle_name");
			String vehicleModel= rst.getString("vehicle_model");
			String vehicleYear= rst.getString("vehicle_year");
			float dailyRate= rst.getFloat("daily_rate");
			int availabilityStatus= rst.getInt("availability_status");
			int passengerCapacity= rst.getInt("passenger_capacity");
			String engineCapacity= rst.getString("engine_capacity");
			Vehicle vehicle = new Vehicle(id, vehicleName , vehicleModel, vehicleYear, dailyRate, availabilityStatus, passengerCapacity, engineCapacity, vendorId);
			list.add(vehicle);
		}
		DBConnection.dbClose();		
		return list;
	}


}
