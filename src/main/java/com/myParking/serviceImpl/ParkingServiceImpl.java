package com.myParking.serviceImpl;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	ParkingArea parkingList[];

	public ParkingServiceImpl() {

	}

	public void createParkingLot(int capacity) {

		parkingList = new ParkingArea[capacity];
		/*int slot = 1;
		for (int i = 0; i < capacity; i++) {
			ParkingArea pa = new ParkingArea();
			Vehicle vehicle = new Vehicle();
			pa.setId(slot);
			pa.setSlot(false);
			pa.setVehicle(vehicle);
			parkingList[i] = pa;
			slot++;
		}*/
	}

	public int park(Vehicle vehicle) {

		int position = getFreeSlot();
		if (position >= 0) {
			ParkingArea pa = new ParkingArea();
			pa.setId(position);
			pa.setSlot(true);
			pa.setVehicle(vehicle);
			parkingList[position] = pa;
		} else {
			System.out.println("Sorry, parking lot is full");
		}
		return position;

	}

	private int getFreeSlot() {
		int slot = -1;
		
		for (int i = 0; i < parkingList.length; i++) {
			if (parkingList[i] ==  null) {
				slot = i;
				break;
			}
		}
		return slot;
	}

	public int leave(int areaId) {
		ParkingArea pa = new ParkingArea();
		pa.setId(areaId);
		pa.setSlot(false);
		pa.setVehicle(null);
		parkingList[areaId-1] = pa;
		return areaId;
	}

	public ParkingArea[] getParkinglotStatus() {
		return this.parkingList;
	}

	public String getSlots(String color) {
		String result = "";
		for (int i = 0; i < parkingList.length; i++) {
			if (parkingList[i].getVehicle().getColor().equals(color)) {
				result = result + " " + (i + 1);
			}

		}
		return result.substring(1);
	}

	public String getVehicleByColor(String color) {
		String vehicleNumbers = "";

		for (int i = 0; i < parkingList.length; i++) {
			if (parkingList[i].getVehicle().getColor().equals(color)) {
				vehicleNumbers = vehicleNumbers + "," + parkingList[i].getVehicle().getRegistrationNo();
			}

		}

		return vehicleNumbers.substring(1);

	}

	public int getSlotOfVehicle(String registrationNumber) {
		int areaId = 0;
		for (int i = 0; i < parkingList.length; i++) {
			if (parkingList[i].getVehicle().getRegistrationNo().equals(registrationNumber)) {
				areaId = i + 1;
			}

		}
		return areaId;
	}
}
