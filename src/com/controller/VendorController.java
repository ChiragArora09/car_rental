package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.model.Vendor;
import com.service.VendorService;

public class VendorController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VendorService vendorService = new VendorService();
		
		int vendor_id = -1; // vendorId = -1 means no vendor is logged in
		String name = null;
		
		if(args[0] != null) {
			String loggedInUserId = args[0];
			
			int id = Integer.parseInt(loggedInUserId);
			
			try {
				Vendor v1 = vendorService.getVendor(id);
				vendor_id = v1.getId();
				name = v1.getName();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
				
		
		System.out.println("Hello, " + name + "Id: " + vendor_id);
		
		while(true) {
			System.out.println("----------VENDOR MENU-------------"); // VENDOR MENU
			System.out.println("Press 1. VEHICLES");
			System.out.println("Press 2. Bookings");
			System.out.println("Press 3. Previous bookings and customers");
			System.out.println("Press 4. Reviews on my vehicles");
			System.out.println("Press 0. Exit");
			
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out...");
				break;
			}
			
			switch(input) {
			
			case 1:
				System.out.println("_____________________________________________VEHICLES_____________________________________________");
				VehicleController.VehicleMenu(vendor_id);
				break;
			
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			default:
				System.out.println("Invalid input given, try again!!!");
			}

		}
		
	}

	
	public static void VendorMenu(int id) {
		int vendorId = id;
		String loggedInUserId = Integer.toString(vendorId);
		String[] menu= {""};
		menu[0] = loggedInUserId;
		main(menu);
	}

}
