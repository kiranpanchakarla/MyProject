package com.myParking.serviceImpl;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	Vehicle vehicleList[];
	boolean slots[];
	ParkingArea parkingList[];
	public ParkingServiceImpl() {
		
	}

	public void createParkingLot(int capacity) {
       
		
		slots = new boolean[capacity];
		vehicleList = new Vehicle[capacity];
		parkingList = new ParkingArea[capacity];
		int slot = 1;
		for(int i=0; i < capacity; i++) {
			ParkingArea pa = new ParkingArea();
			pa.setId(slot);
			pa.setSlot(false);
			parkingList[i] = pa;
			slot++;
		}
	}

	public int park(Vehicle vehicle) {

		int areaId = getFreeSlot();
		if (areaId > 0) {
		vehicleList[areaId-1] = vehicle;
		parkingList[areaId-1].setSlot(true);
		}else {
			System.out.println("Sorry, parking lot is full");
		}
		return areaId;

	}


	private int getFreeSlot() {
		int slot = 0;
		 for(int i=0; i< parkingList.length;i++) {
			 if(parkingList[i].isSlot() == false) {
				 slot =parkingList[i].getId();
				 break;
			 }
		 }
		return slot;
	}

	public int leave(int areaId) {
		vehicleList[areaId-1] = null;
		parkingList[areaId-1].setSlot(false);
		return areaId;
	}

	public Vehicle[] getParkinglotStatus() {
		return this.vehicleList;
	}

	public String getSlots(String color) {
		String result = "";
		for(int i=0; i<vehicleList.length ;i++) {
			if(vehicleList[i].getColor().equals(color)) {
				result = result + " "+ (i+1);
			}
			
		}
		return result.substring(1);
	}

	public String getVehicleByColor(String color) {
		String vehicleNumbers = "";
		
		for(int i=0; i<vehicleList.length ;i++) {
			if(vehicleList[i].getColor().equals(color)) {
				vehicleNumbers = vehicleNumbers + "," +  vehicleList[i].getRegistrationNo();
			}
			
		}
		
		return vehicleNumbers.substring(1);

       
	}

	public int getSlotOfVehicle(String registrationNumber) {
		int areaId = 0;
		for(int i=0; i<vehicleList.length ;i++) {
			if(vehicleList[i].getRegistrationNo().equals(registrationNumber)) {
				areaId = i+1; 
			}
			
		}
		return areaId;
	}
}
