package com.myParking.model;

public class Vehicle {

	private String registrationNo; // vehicle registration number
	private String color; // vehicle color

	// Constructor
	public Vehicle() {
	}

	public Vehicle(String registrationNo, String color) {
		this.registrationNo = registrationNo;
		this.color = color;
	}

	// Getters and Setters
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

}
