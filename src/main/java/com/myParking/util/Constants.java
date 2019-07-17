package com.myParking.util;

public enum Constants {
	
	slotColor("slot_numbers_for_cars_with_colour"),
	registerColor("registration_numbers_for_cars_with_colour"),
	slotRegister("slot_number_for_registration_number");
	
	private String constant;

	Constants(String constant) {
		this.constant = constant;
	}

	public String getConstant() {
		return constant;
	}


}
