package com.myParking.serviceImpl;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.util.Constants;

public class ParkingServiceImpl implements ParkingService {

	ParkingArea parkingList[];

	public ParkingServiceImpl() {

	}

	public void createParkingLot(int capacity) {

		parkingList = new ParkingArea[capacity];
		System.out.println("Created a parking lot with " + capacity + " slots");
	}

	public int park(Vehicle vehicle) {

		int position = getPosition();
		int slot = position + 1;
		if (position >= 0) {
			ParkingArea pa = new ParkingArea();

			pa.setId(slot);
			pa.setVehicle(vehicle);
			parkingList[position] = pa;
		} else {
			System.out.println("Sorry, parking lot is full");
		}
		return slot;

	}

	private int getPosition() {
		int slot = -1;

		for (int i = 0; i < parkingList.length; i++) {
			if (parkingList[i] == null) {
				slot = i;
				break;
			}
		}
		return slot;
	}

	public int leave(int areaId) {
		if (parkingList.length > areaId) {

			parkingList[areaId - 1] = null;
			System.out.println("Slot number " + areaId + " is free");
		} else {
			System.out.println("Slot number " + areaId + " doesnt exists!");
		}

		return areaId;
	}

	public void getParkinglotStatus() {
		System.out.println("Slot No." + " " + "Registration No" + " " + "Colour");
		for (ParkingArea e : parkingList) {
			if (e != null) {
				System.out.println(
						e.getId() + "\t" + e.getVehicle().getRegistrationNo() + "\t" + e.getVehicle().getColor());
			}
		}
	}

	public void getDetials(String details, String method) {

		String result = "";
		int slot = 0;
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
						slot = i + 1;
					}
				}

			}

		}

		if (method.equals(Constants.slotRegister.getConstant())) {
			if (slot != 0) {
				System.out.println(slot);
			} else {
				System.out.println("Not found");
			}
		} else {
			System.out.println(result.substring(1));
		}

	}
}
