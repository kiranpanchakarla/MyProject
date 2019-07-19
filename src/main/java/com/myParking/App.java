package com.myParking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;
import com.myParking.util.Constants;

/**
 * Hello world!
 *
 */
public class App {
	static ParkingService parkingService;

	public static void main(String[] args) {
		parkingService = new ParkingServiceImpl();

		// file input

		 if(args.length > 0)
        {
            String fileName = args[0];
            processFileInput(fileName);
        }
        else
        {
            printAvailableCommands();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String commandln = scanner.nextLine();
                processCommand(commandln);
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
	}

	private static void create_parking_lot(int areaId) {
		parkingService.createParkingLot(areaId);
	}

	private static void park(String registrationNumber, String color) {

		int areaId = parkingService.park(new Vehicle(registrationNumber, color));
		if (areaId > 0) {
			System.out.println("Allocated slot number: " + areaId);
		}

	}

	private static void leave(int areaId) {
		parkingService.leave(areaId);
	}

	private static void status() {
		parkingService.getParkinglotStatus();
	}

	private static void registration_numbers_for_cars_with_colour(String color) {
		parkingService.getDetials(color, Constants.registerColor.getConstant());
	}

	private static void slot_number_for_registration_number(String registrationNumber) {
		parkingService.getDetials(registrationNumber, Constants.slotRegister.getConstant());
	}

	private static void slot_numbers_for_cars_with_colour(String color) {
		parkingService.getDetials(color, Constants.slotColor.getConstant());
	}

	private static void processCommand(String commandln) {
		String sample = commandln.trim().toLowerCase();
		String[] commandInput = sample.trim().split("\\s+");
		String command = commandInput[0];
		 
		if(command.contains(Constants.create.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				int nrOfSlots = Integer.parseInt(commandInput[1]);
				create_parking_lot(nrOfSlots);
			}
		} else if (command.equals(Constants.park.getConstant())) {
			if (commandInput.length != 3) {
				System.out.println("Invalid input");
			} else {
				String registrationNumber = commandInput[1];
				String color = commandInput[2];
				park(registrationNumber, color);
			}
		} else if (command.equals(Constants.leave.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				int slotId = Integer.parseInt(commandInput[1]);
				leave(slotId);
			}
		} else if (command.equals(Constants.status.getConstant())) {
			if (commandInput.length != 1) {
				System.out.println("Invalid input");
			} else {
				status();
			}
		} else if (command.equals(Constants.registerColor.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String color = commandInput[1];
				registration_numbers_for_cars_with_colour(color);
			}
		} else if (command.equals(Constants.slotColor.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String color = commandInput[1];
				slot_numbers_for_cars_with_colour(color);
			}
		} else if (command.equals(Constants.slotRegister.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String regNo = commandInput[1];
				slot_number_for_registration_number(regNo);
			}
		} else {
			System.out.println("Invalid command");
		}

	}

	private static void processFileInput(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				processCommand(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
