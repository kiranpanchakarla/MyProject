package com.myParking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	static ParkingService parkingService;

	public static void main(String[] args) {
		parkingService = new ParkingServiceImpl();

		
		 /*create_parking_lot(6); 
		 park("KA01HH1234", "White"); 
		 park("KA01HH9999","White"); 
		 park("KA01BB0001", "Black"); 
		 park("KA01HH7777", "Red");
		 park("KA01HH2701", "Blue"); 
		 park("KA01HH3141", "Black"); 
		 leave(4); status();
		 park("KA01P333", "White"); 
		 park("DL12AA9999", "White");
		  registration_numbers_for_cars_with_colour("White");
		  slot_numbers_for_cars_with_colour("White");
		  slot_number_for_registration_number("KA01HH3141");
		  slot_number_for_registration_number("MH04AY1111");*/
		 

		// file input
		if (args.length > 0) {
			String fileName = args[0];
			System.out.println("********************* Going to execute the file input*********************");
			processFileInput(fileName);
		} else {
			System.out.println("==============================================================================");
			System.out.println("********************* WELCOME TO PARKING LOT CONSOLE *********************");
			System.out.println("==============================================================================");
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
		System.out.println("\t help");
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
		System.out.println("Created a parking lot with " + areaId + " slots");
	}

	private static void park(String registrationNumber, String color) {

		int areaId = parkingService.park(new Vehicle(registrationNumber, color));
		if (areaId > 0) {
			System.out.println("Allocated slot number: " + areaId);
		}
			

	}

	private static void leave(int areaId) {
		parkingService.leave(areaId);
		System.out.println("Slot number " + areaId + " is free");
	}

	private static void status() {
		Vehicle[] list = parkingService.getParkinglotStatus();
		System.out.println("Slot No." + "\t" + "Registration No" + "\t" + "Colour");
		int count = 1;
		for (Vehicle e : list) {
			if (e != null) {
				System.out.println(count + "\t" + e.getRegistrationNo() + "\t" + e.getColor());
			}
			count++;
		}
	}

	private static void registration_numbers_for_cars_with_colour(String color) {

		String list = parkingService.getVehicleByColor(color);

		System.out.println(list);
	}

	private static void slot_number_for_registration_number(String registrationNumber) {
		int areaId = parkingService.getSlotOfVehicle(registrationNumber);
		if (areaId == 0) {
			System.out.println("Not found");
		} else {
			System.out.println(areaId);
		}
	}

	private static void slot_numbers_for_cars_with_colour(String color) {
		String pa = parkingService.getSlots(color);

		System.out.println(pa);
	}

	private static void processCommand(String commandln) {
		String[] commandInput = commandln.split(" ");
		String command = commandInput[0];
		if ("help".equals(command)) {
			printAvailableCommands();
		} else if ("create_parking_lot".equals(command)) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				int nrOfSlots = Integer.parseInt(commandInput[1]);
				create_parking_lot(nrOfSlots);
			}
		} else if ("park".equals(command)) {
			if (commandInput.length != 3) {
				System.out.println("Invalid input");
			} else {
				String registrationNumber = commandInput[1];
				String color = commandInput[2];
				park(registrationNumber, color);
			}
		} else if ("leave".equals(command)) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				int slotId = Integer.parseInt(commandInput[1]);
				leave(slotId);
			}
		} else if ("status".equals(command)) {
			if (commandInput.length != 1) {
				System.out.println("Invalid input");
			} else {
				status();
			}
		} else if ("registration_numbers_for_cars_with_colour".equals(command)) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String color = commandInput[1];
				registration_numbers_for_cars_with_colour(color);
			}
		} else if ("slot_numbers_for_cars_with_colour".equals(command)) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String color = commandInput[1];
				slot_numbers_for_cars_with_colour(color);
			}
		} else if ("slot_number_for_registration_number".equals(command)) {
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
	
	private static void processFileInput(String fileName)
    {
        BufferedReader br = null;
        FileReader fr = null;
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null)
            {
                processCommand(sCurrentLine);
            }
 
        } catch (IOException e) {

            e.printStackTrace();

        } finally
        {
                try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
}
