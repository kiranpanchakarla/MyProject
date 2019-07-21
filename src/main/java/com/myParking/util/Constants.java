package com.myParking.util;

public enum Constants { // commands taken as enum constants

	slotColor("slot_numbers_for_cars_with_colour"), 
	registerColor("registration_numbers_for_cars_with_colour"),
	slotRegister("slot_number_for_registration_number"), 
	create("create_parking_lot"), 
	park("park"), 
	leave("leave"),
	status("status");

	private String constant;

	Constants(String constant) {
		this.constant = constant;
	}

	public String getConstant() {
		return constant;
	}

}
