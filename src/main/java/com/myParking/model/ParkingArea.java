package com.myParking.model;

public class ParkingArea {

	private int id;
	
	private boolean slot; 

	private Vehicle vehicle;
	
	
	public ParkingArea() {
		
	}

	public ParkingArea(int id, boolean slot, Vehicle vehicle) {
		this.id = id;
		this.slot = slot;
		this.vehicle = vehicle;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isSlot() {
		return slot;
	}


	public void setSlot(boolean slot) {
		this.slot = slot;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	@Override
	public String toString() {
		return "ParkingArea [id=" + id + ", slot=" + slot + ", vehicle=" + vehicle + "]";
	}


	
	 


	
}
