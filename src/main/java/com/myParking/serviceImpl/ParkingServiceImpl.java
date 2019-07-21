package com.myParking.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.util.Constants;

public class ParkingServiceImpl implements ParkingService {

	ParkingArea parkingList[];

	public ParkingServiceImpl() {

	}

	// Creates a new parking area with the capacity entered.
	public int createParkingLot(int capacity) {
		if (parkingList == null) { // if parkingList is null, creates new parkingList
			parkingList = new ParkingArea[capacity];
		} else {// can increase the size of parkingList
			parkingList = Arrays.copyOf(parkingList, parkingList.length + capacity);
		}
		int slots = parkingList.length;
		System.out.println("Created a parking lot with " + slots + " slots");
		return slots;
	}

	// park vehicle in the parking slot
	public int park(Vehicle vehicle) {

		int position = getPosition(); // checks which position of parkingList is empty
		int slot = position + 1; // add 1 as position starts from 0
		if (parkingList != null) {
			if (position >= 0) {
				ParkingArea pa = new ParkingArea(); // park vehicle in empty slot
				pa.setId(slot);
				pa.setVehicle(vehicle);
				parkingList[position] = pa;
				System.out.println("Allocated slot number: " + slot);
			} else {
				System.out.println("Sorry, parking lot is full");
			}
		} else {
			System.out.println("Invalid Command");
		}
		return slot;
	}

	// get position of parkingList which is null
	public int getPosition() { // return which position is null in the parkingList
		int slot = -1;
		if (parkingList != null) {
			for (int i = 0; i < parkingList.length; i++) {
				if (parkingList[i] == null) {
					slot = i;
					break;
				}
			}
		}

		return slot;
	}

	// when vehicle leaves the parking area, make that position to null
	public int leave(int areaId) {
		if (parkingList != null) {// null check
			if (parkingList.length > areaId) {
				parkingList[areaId - 1] = null;// set parkingList position to null
				System.out.println("Slot number " + areaId + " is free");
			} else {
				System.out.println("Slot number " + areaId + " doesnt exists!");
			}
		} else {
			System.out.println("Invalid Command");
		}
		return areaId;
	}

	// get list of vehicles parked in parking area
	public void getParkinglotStatus() {
		if (parkingList != null) {// null check
			System.out.println("Slot No." + " " + "Registration No" + " " + "Colour");
			for (ParkingArea e : parkingList) {
				if (e != null) {
					System.out.println(
							e.getId() + "\t" + e.getVehicle().getRegistrationNo() + "\t" + e.getVehicle().getColor());
				}
			}
		}
	}

	// get slot number, color and registration number based on requirement
	public void getDetials(String details, String method) {

		String result = "";
		if (parkingList != null) {// null check
			for (int i = 0; i < parkingList.length; i++) {
				if (parkingList[i] != null) {
					// get slot number based on color
					if (method.equals(Constants.slotColor.getConstant())) {
						if (parkingList[i].getVehicle().getColor().equals(details)) {
							result = result + " " + (i + 1);
						}
					} else if (method.equals(Constants.registerColor.getConstant())) {
						// get registration number based on color
						if (parkingList[i].getVehicle().getColor().equals(details)) {
							result = result + "," + parkingList[i].getVehicle().getRegistrationNo();
						}
					} else {
						// get slot number based on registration number
						if (parkingList[i].getVehicle().getRegistrationNo().equals(details)) {
							result = " " + Integer.toString(i + 1);
						}
					}

				}

			}

			if (result != "") {
				System.out.println(result.substring(1));
			} else {
				System.out.println("Not found");
			}

		}
	}
    // Read input file
	public void processFile(String fileName) {

		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			br = new BufferedReader(fr);

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
    //process commands entered by user
	public void processCommand(String commandln) {

		String sample = commandln.trim().toLowerCase();
		String[] commandInput = sample.trim().split("\\s+");
		String command = commandInput[0];

		if (command.contains(Constants.create.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				int nrOfSlots = Integer.parseInt(commandInput[1]);
				createParkingLot(nrOfSlots);
			}
		} else if (command.equals(Constants.park.getConstant())) {
			if (commandInput.length != 3) {
				System.out.println("Invalid input");
			} else {
				String registrationNumber = commandInput[1];
				String color = commandInput[2];
				Vehicle vehilce = new Vehicle();
				vehilce.setRegistrationNo(registrationNumber);
				vehilce.setColor(color);
				park(vehilce);
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
				getParkinglotStatus();
			}
		} else if (command.equals(Constants.registerColor.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String color = commandInput[1];
				getDetials(color, Constants.registerColor.getConstant());
			}
		} else if (command.equals(Constants.slotColor.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String color = commandInput[1];
				getDetials(color, Constants.slotColor.getConstant());
			}
		} else if (command.equals(Constants.slotRegister.getConstant())) {
			if (commandInput.length != 2) {
				System.out.println("Invalid input");
			} else {
				String regNo = commandInput[1];
				getDetials(regNo, Constants.slotRegister.getConstant());
			}
		} else {
			System.out.println("Invalid command");
		}

	}
}
