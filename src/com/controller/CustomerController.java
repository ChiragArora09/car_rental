package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.model.Lease;
import com.model.Vehicle;
import com.service.CustomerService;
import com.service.LeaseService;
import com.service.VehicleService;

public class CustomerController {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		VehicleService vehicleService = new VehicleService();
		LeaseService leaseService = new LeaseService();
		Scanner sc = new Scanner(System.in);
		
		int customer_id=-1; // customer_id=-1 means no user is logged in
		String name = null;
		
		if(args[0] != null) {
			String loggedInUserId = args[0];
			
			int id = Integer.parseInt(loggedInUserId);
			
			try {
				Customer c1 = customerService.getCustomer(id);
				customer_id = c1.getId();
				name = c1.getFirst_name() + " " + c1.getLast_name();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		System.out.println("Hello, " + name);
		
		while(true) {
			// CUSTOMER MENU
			System.out.println("");
			System.out.println("Press 1. All Cars");
			System.out.println("Press 2. Book Car");
			System.out.println("Press 3. My bookings");
			System.out.println("Press 4. History");
			System.out.println("Press 0. to Exit");
			
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out...");
				break;
			}
			
			switch(input) {
			
			case 1:
				try {
					List<Vehicle> vehicles = vehicleService.getAllCars();
					System.out.println("VEHICLE_NAME  VEHICLE_MODEL  DAILY_RATE  PASSENGER_CAPACITY  ENGINE_CAPACITY  AVAILABILITY_STATUS");
					for(Vehicle v : vehicles){
						System.out.println(v.getVehicle_name() + " " + v.getVehicle_model() + " " + v.getDaily_rate() + " " + v.getPassenger_capacity() + " " + v.getEngine_capacity() + " " + v.getAvailability_status());
					}
				} catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 2:
				try {
					System.out.println("+++++++++++++++++++++++++++++ BOOKING VEHICLE +++++++++++++++++++++++++++++++++");
					List<Vehicle> vehicles = vehicleService.getAvailableCars(); // calling the function
					System.out.println("ID  VEHICLE_NAME  VEHICLE_MODEL  DAILY_RATE  PASSENGER_CAPACITY  ENGINE_CAPACITY");
					for(Vehicle v : vehicles){
						System.out.println(v.getId() + " " + v.getVehicle_name() + " " + v.getVehicle_model() + " " + v.getDaily_rate() + " " + v.getPassenger_capacity() + " " + v.getEngine_capacity());
					}
					
					// Choosing a vehicle and booking it
					System.out.println("Please enter the vehicle ID"); // vehicle id
					int vehicleId = sc.nextInt();
					System.out.println("Please enter the starting date/(YYYY-MM-DD)");
					sc.nextLine(); // starting date of the rent
					String startingDate = sc.nextLine();
					System.out.println("Please enter the ending date/(YYYY-MM-DD)"); // ending date of the rent
					String endingDate = sc.nextLine();
					
					System.out.println("If you are leasing a vehicle for more than a month then please enter Long Term else enter Short Term");
					String type = sc.nextLine();
					
				    String status = "pending"; // lease status
				    
				    Lease lease = new Lease(customer_id, vehicleId, startingDate, endingDate, status, type); // lease object
				    
				    try {
				    	int booking_status = leaseService.bookVehicle(lease);
				    	if(booking_status==1) {
				    		System.out.println("Vehicle has been booked successfully from " + lease.getStart_date() + " to " + lease.getEnd_date());
				    	}
				    }catch(SQLException e) {
				    	System.out.println(e.getMessage());
				    }
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
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
	
	public static void customerMenu(int id) {
		int user_id = id;
		String loggedInUserId = Integer.toString(user_id);
		String[] menu= {""};
		menu[0] = loggedInUserId;
		main(menu);
	}

}
