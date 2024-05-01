package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.CustomerHistoryDto;
import com.model.CustomerHistory;
import com.model.Lease;
import com.service.CustomerHistoryService;

public class CustomerHistoryController {

	public static void main(String[] args) {
		
		int cust_id=-1;
		
		if(args[0] != null) {
			String loggedInUserId = args[0];
			cust_id = Integer.parseInt(loggedInUserId);
		}
		
		CustomerHistoryService customerHistoryService = new CustomerHistoryService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Press 1: View Completed Deals");
			System.out.println("Press 2: View Ongoing Deals");
			System.out.println("Press 3: View Upcoming Deals");
			System.out.println("Press 0:Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Customer History...");
				break;
			}
			switch(input) {
			case 1:
				try {
					List<CustomerHistoryDto> customerHistorylist = customerHistoryService.findAll(cust_id);
					System.out.println("VEHICLE-ID   VEHICLE-NAME   AMOUNT   DISCOUNT   DAMAGED");
					System.out.println("");
					for(CustomerHistoryDto c:customerHistorylist) {
						System.out.println(c.getVehicleId() + "  " + c.getVehicleName() + "  " + c.getFinalAmount() + "  " + c.getDiscount() + "  " + c.getDamageReported());
					}
					System.out.println("");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				try {
					System.out.println("-------------Ongoiong Deals---------");
					List<Lease> leaselist = customerHistoryService.GetOngoingDeals(cust_id);
					System.out.println("VehicleID   START-DATE   END-DATE   STATUS   TYPE");
					for(Lease l:leaselist) {
						System.out.println(l.getVehicle_id() + "  " + l.getStart_date() + "  " + l.getEnd_date() + "  " + l.getStatus()+ "  " + l.getType());
					}
					System.out.println("");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 3:
				try {
					System.out.println("-------------Upcoming/Pending Deals---------");
					List<Lease> leaselist = customerHistoryService.GetPendingDeals(cust_id);
					System.out.println("VehicleID   START-DATE   END-DATE   STATUS   TYPE");
					for(Lease l:leaselist) {
						System.out.println(l.getVehicle_id() + "  " + l.getStart_date() + "  " + l.getEnd_date() + "  " + l.getStatus()+ "  " + l.getType());
					}
					System.out.println("");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				
				}
				
			}
					
		}

	public static void CustomerMenu(int customer_id) {
		int user_id = customer_id;
		String loggedInUserId = Integer.toString(user_id);
		String[] menu= {""};
		menu[0] = loggedInUserId;
		main(menu);
	}

}
