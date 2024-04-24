package com.controller;

import java.util.Scanner;

public class VendorController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("----------CUSTOMER MENU-------------"); // CUSTOMER MENU
			System.out.println("Press 1. All Cars");
			System.out.println("Press 2. Book Car");
			System.out.println("Press 3. My bookings");
			System.out.println("Press 4. History");
			System.out.println("Press 0. to Exit");
			
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Leaving Car rental");
				break;
			}
			
			switch(input) {
			
			case 1:
				System.out.println();
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

}
