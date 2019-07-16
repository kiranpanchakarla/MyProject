package com.myParking.model;

public class ParkingArea {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParkingArea(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "ParkingArea [id=" + id + "]";
	}
	
	
}
