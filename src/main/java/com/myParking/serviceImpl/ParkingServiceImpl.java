package com.myParking.serviceImpl;

import java.util.Arrays;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.util.Constants;

public class ParkingServiceImpl implements ParkingService {

	ParkingArea parkingList[];

	public ParkingServiceImpl() {

	}

	public int createParkingLot(int capacity) {
		if (parkingList == null) {
			parkingList = new ParkingArea[capacity];
		} else {// can increase the size of array
			parkingList = Arrays.copyOf(parkingList, parkingList.length + capacity);
		}
		// parkingList = new ParkingArea[capacity];
		int slots = parkingList.length;
		System.out.println("Created a parking lot with " + slots + " slots");
		return slots;
	}

	public int park(Vehicle vehicle) {

		int position = getPosition();
		int slot = position + 1;
		if (parkingList != null) {
			if (position >= 0) {
				ParkingArea pa = new ParkingArea();

				pa.setId(slot);
				pa.setVehicle(vehicle);
				parkingList[position] = pa;
			} else {
				System.out.println("Sorry, parking lot is full");
			}
		} else {
			System.out.println("Invalid Command");
		}

		return slot;

	}

	private int getPosition() {
		int slot = -1;
		if (parkingList != null) {
			if (parkingList.length != 0) {
				for (int i = 0; i < parkingList.length; i++) {
					if (parkingList[i] == null) {
						slot = i;
						break;
					}
				}
			}
		}

		return slot;
	}

	public int leave(int areaId) {
		if (parkingList != null) {
			if (parkingList.length > areaId) {
				parkingList[areaId - 1] = null;
				System.out.println("Slot number " + areaId + " is free");
			} else {
				System.out.println("Slot number " + areaId + " doesnt exists!");
			}
		} else {
			System.out.println("Invalid Command");
		}
		return areaId;
	}

	public void getParkinglotStatus() {
		if (parkingList != null) {
			System.out.println("Slot No." + " " + "Registration No" + " " + "Colour");
			for (ParkingArea e : parkingList) {
				if (e != null) {
					System.out.println(
							e.getId() + "\t" + e.getVehicle().getRegistrationNo() + "\t" + e.getVehicle().getColor());
				}
			}
		}
	}

	public void getDetials(String details, String method) {

		String result = "";
		//int slot = 0;
		if (parkingList != null) {
			for (int i = 0; i < parkingList.length; i++) {
				if (parkingList[i] != null) {
					if (method.equals(Constants.slotColor.getConstant())) {
						if (parkingList[i].getVehicle().getColor().equals(details)) {
							result = result + " " + (i + 1);
						}
					} else if (method.equals(Constants.registerColor.getConstant())) {
						if (parkingList[i].getVehicle().getColor().equals(details)) {
							result = result + "," + parkingList[i].getVehicle().getRegistrationNo();
						}
					} else {
						if (parkingList[i].getVehicle().getRegistrationNo().equals(details)) {
							result = " " + Integer.toString(i + 1);
						}
					}

				}

			}
            
			/*if (method.equals(Constants.slotRegister.getConstant())) {
				if (slot != 0) {
					System.out.println(slot);
				} else {
					System.out.println("Not found");
				}
			} else {
				System.out.println(result.substring(1));
			}*/
			if( result != "") {
				System.out.println(result.substring(1));
			}else {
				System.out.println("Not found");
			}
			
		}
	}
}
