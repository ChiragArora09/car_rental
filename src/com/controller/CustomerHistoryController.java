package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.CustomerHistory;
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
			System.out.println("--------Customer History--------");
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
					List<CustomerHistory> customerHistorylist = customerHistoryService.findAll(cust_id);
					for(CustomerHistory c:customerHistorylist) {
						System.out.println(c.getCustomer_id());
					}
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
