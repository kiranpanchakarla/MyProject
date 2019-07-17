package com.myParking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.BeforeClass;
import org.junit.Test;
import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

public class VehicleParkingTestCases {

	static ParkingService parkingService;
	 int numSlots =6;

	@BeforeClass
	public static void setup() {
		parkingService = new ParkingServiceImpl();
	}


	@Test
	public void park() throws Exception {
		parkingService.createParkingLot(numSlots);
		System.out.println("Created a parking lot with " + numSlots + " slots");
		int slotId = parkingService.park(new Vehicle("KA-01-HH-1234", "White"));
		assertEquals(1, slotId);
		System.out.println("Allocated slot number:" + slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-9999", "White"));
		assertEquals(2, slotId);
		System.out.println("Allocated slot number:" + slotId);

		slotId = parkingService.park(new Vehicle("KA-01-BB-0001", "Black"));
		assertEquals(3, slotId);
		System.out.println("Allocated slot number:" + slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-7777", "Red"));
		assertEquals(4, slotId);
		System.out.println("Allocated slot number:" + slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-2701", "Blue"));
		assertEquals(5, slotId);
		System.out.println("Allocated slot number:" + slotId);

		slotId = parkingService.park(new Vehicle("KA-01-HH-3141", "Black"));
		assertEquals(6, slotId);
		System.out.println("Allocated slot number:" + slotId);
	}

	@Test
	public void leave() throws Exception {
		
		int areaId = 4;
		parkingService.leave(areaId );
		System.out.println("Slot number " + areaId +" is free");
	 	
	}
	
	/*@Test
	public void status() throws Exception {
		parkingService.createParkingLot(6);
		parkingService.park(new Vehicle("KA-01-HH-1234", "White"));
		parkingService.park(new Vehicle("KA-01-HH-9999", "White"));
		parkingService.park(new Vehicle("KA-01-BB-0001", "Black"));
		parkingService.park(new Vehicle("KA-01-HH-7777", "Red"));
		parkingService.park(new Vehicle("KA-01-HH-2701", "Blue"));
		parkingService.park(new Vehicle("KA-01-HH-3141", "Black"));
		parkingService.leave(areaId);
		
		ParkingArea[] list = parkingService.getParkinglotStatus();
		System.out.println("Slot No." + " " + "Registration No" + " " + "Colour");
		for (ParkingArea e : list) {
			if (e.getVehicle() != null) {
				System.out.println(e.getId() + "\t" + e.getVehicle().getRegistrationNo() + "\t" + e.getVehicle().getColor());
			}
		}
	}*/
	

}
