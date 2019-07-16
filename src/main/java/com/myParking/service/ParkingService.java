package com.myParking.service;

import java.util.List;
import java.util.Map;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;

public interface ParkingService {

	public void createParkingLot(int capacity);

	public int park(Vehicle vehicle);

	public int leave(int areaId);

	public Vehicle[] getParkinglotStatus();

	public List<Vehicle> getRegistrationNumbers(String color);

	public ParkingArea getSlotForVehicle(String registrationNumber);

	public List<ParkingArea> getSlots(String color);

}
