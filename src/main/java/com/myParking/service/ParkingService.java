package com.myParking.service;


import com.myParking.model.Vehicle;


public interface ParkingService {

	public void createParkingLot(int capacity);
	
	public int park(Vehicle vehicle);
}
