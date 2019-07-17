package com.myParking.model;

public class ParkingArea {

	private int id;
	
	private boolean slot = false; 

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

	public ParkingArea(int id, boolean slot) {
		super();
		this.id = id;
		this.slot = slot;
	}
	
	public ParkingArea() {
		
	}

	@Override
	public String toString() {
		return "ParkingArea [id=" + id + ", slot=" + slot + "]";
	}



	
}
