package com.myParking.serviceImpl;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.util.Constants;

public class TestParkingServiceImpl {

	static ParkingService parkingService;
	int numSlots = 6;
	int areaId = 4;
	String registrationNumber ="KA01HH3141";
	String color = "White";

	@BeforeClass
	public static void setup() {
		parkingService = new ParkingServiceImpl();
	}

	@Test
	public void testCreateParkingLot() {
		int capacity = parkingService.createParkingLot(numSlots);
		assertEquals(6, capacity);
	}

	@Test
	public void testPark() {
		parkingService = new ParkingServiceImpl();
		testCreateParkingLot();
		
		int slotId = parkingService.park(new Vehicle("KA-01-HH-1234", "White"));
		assertEquals(1, slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-9999", "White"));
		assertEquals(2, slotId);

		slotId = parkingService.park(new Vehicle("KA-01-BB-0001", "Black"));
		assertEquals(3, slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-7777", "Red"));
		assertEquals(4, slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-2701", "Blue"));
		assertEquals(5, slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-3141", "Black"));
		assertEquals(6, slotId);

	}

	@Test
	public void testLeave() {
		parkingService = new ParkingServiceImpl();
		testCreateParkingLot();
		testPark();
		parkingService.leave(areaId);
	}

	@Test
	public void testGetParkinglotStatus() {
		parkingService = new ParkingServiceImpl();
		testCreateParkingLot();
		testPark();
		testLeave();
		
		parkingService.getParkinglotStatus();
	}
	
	@Test
	public void getDetials() {
		parkingService = new ParkingServiceImpl();
		testCreateParkingLot();
		testPark();
		testLeave();
		testGetParkinglotStatus();
		
		parkingService.getDetials(color, Constants.registerColor.getConstant());
		
		parkingService.getDetials(color, Constants.slotColor.getConstant());
		
		parkingService.getDetials(registrationNumber, Constants.slotRegister.getConstant());

	}

}
