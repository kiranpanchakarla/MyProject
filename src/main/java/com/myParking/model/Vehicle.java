package com.myParking.model;

public class Vehicle {

	private String	registrationNo	= null;
	private String	color = null;
	
	public Vehicle(String registrationNo, String color) {
		super();
		this.registrationNo = registrationNo;
		this.color = color;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNo=" + registrationNo + ", color=" + color + "]";
	}
	
	
}
