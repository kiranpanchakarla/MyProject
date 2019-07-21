package com.myParking.service;

import com.myParking.model.Vehicle;

public interface ParkingService {

	public int createParkingLot(int capacity);

	public int park(Vehicle vehicle);

	public int getPosition();

	public int leave(int areaId);

	public void getParkinglotStatus();

	public void getDetials(String details, String method);

	public void processFile(String fileName);

	public void processCommand(String commandln);

}
