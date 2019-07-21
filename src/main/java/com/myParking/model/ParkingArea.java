package com.myParking.model;

public class ParkingArea {

	private int id; // parking slot number

	private Vehicle vehicle; // vehicle parked in the slot

	// Constructor
	public ParkingArea() {

	}

	// Getter and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
