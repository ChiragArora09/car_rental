package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CustomerHistory;
import com.utility.DBConnection;

public class CustomerHistoryDaoImpl implements CustomerHistoryDao{

	@Override
	public List<CustomerHistory> findAll(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from customer_history where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		ResultSet rst = pstmt.executeQuery();
		List<CustomerHistory> list = new ArrayList<>();
		while(rst.next()) {
			int customerhistoryid=rst.getInt("id");
			System.out.println(customerhistoryid);
			double discount=rst.getDouble("discount");
			double late_return_fee=rst.getDouble("late_return_fee");
			int start_mileage=rst.getInt("start_mileage");
			int end_milage=rst.getInt("end_mileage");
			String DamageReported=rst.getString("any_damage_reported");
			int customerId=rst.getInt("customer_id");
			int vehicleId=rst.getInt("vehicle_id");
			CustomerHistory customerHistory = new CustomerHistory(customerhistoryid, discount, late_return_fee,start_mileage, end_milage,DamageReported,customerId,vehicleId);
			list.add(customerHistory);
		}
		DBConnection.dbClose();
		return list;
	}

}
