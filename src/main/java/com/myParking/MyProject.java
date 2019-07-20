package com.myParking;

import java.util.Scanner;

import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

/**
 * Hello world!
 *
 */
public class MyProject{
	static ParkingService parkingService;

	public static void main(String[] args){
		parkingService = new ParkingServiceImpl();

		// file input
        
		if (args.length > 0) {
			String fileName = args[0];
			parkingService.processFile(fileName);
		}else {
			printAvailableCommands();

			Scanner scanner = new Scanner(System.in);
			while (true) {
				String commandln = scanner.nextLine();
				if(commandln.equalsIgnoreCase("Exit")) {
				    System.exit(0);
				}
				parkingService.processCommand(commandln);
				
				
			}
		}

	}

	private static void printAvailableCommands() {
		System.out.println("Available commands:");
		System.out.println("\t create_parking_lot <slots>");
		System.out.println("\t park <RegistrationNumber> <Color>");
		System.out.println("\t leave <slot>");
		System.out.println("\t status");
		System.out.println("\t registration_numbers_for_cars_with_colour <color>");
		System.out.println("\t slot_numbers_for_cars_with_colour <color>");
		System.out.println("\t slot_number_for_registration_number <registrationNumber>");
		System.out.println("\t Exit");
	}

}
