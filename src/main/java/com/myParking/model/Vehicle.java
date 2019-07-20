package com.myParking.model;

public class Vehicle {

	private String registrationNo;
	private String color;

	public Vehicle() {
	}

	public Vehicle(String registrationNo, String color) {
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

}
