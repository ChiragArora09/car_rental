package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "SELECT * from vehicle WHERE availability_status=1";
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

}
