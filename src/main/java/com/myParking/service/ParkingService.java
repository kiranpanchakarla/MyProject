package com.myParking.service;

import com.myParking.model.Vehicle;

public interface ParkingService {

	public void createParkingLot(int capacity);

	public int park(Vehicle vehicle);

	public int leave(int areaId);

	public Vehicle[] getParkinglotStatus();

	public String getSlots(String color);
	
	public String getVehicleByColor(String color);
	
	public int getSlotOfVehicle(String registrationNumber);

}
