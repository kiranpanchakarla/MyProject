package com.myParking;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

public class MyProjectTesting {

	static ParkingService parkingService;
	
	@Test
	public void test() {
		parkingService = new ParkingServiceImpl();
		
		File file = new File("src/parking_slot.txt");
		String absolutePath = file.getAbsolutePath();
		parkingService.processFile(absolutePath);
		 
	}
	
	@Test
	public void MyProjectTest() {
		String arr[] = new String[1];
		File file = new File("src/parking_slot.txt");
		String absolutePath = file.getAbsolutePath();
		arr[0] = absolutePath;
		MyProject.main(arr);
		
		//String arr1[] = new String[0];
		//MyProject.main(arr1);
	}

	@Test
	public void processCommandTest() {
		
		parkingService.processCommand("create_parking_lot 6 8");
		parkingService.processCommand("park KA­01­HH­1234 White White");
		parkingService.processCommand("leave 4 1");
		parkingService.processCommand("status White");
		parkingService.processCommand("registration_numbers_for_cars_with_colour White White");
		parkingService.processCommand("slot_numbers_for_cars_with_colour White White");
		parkingService.processCommand("slot_number_for_registration_number MH­04­AY­1111 MH­04­AY­1111");
		parkingService.processCommand(" ");
	}
}
