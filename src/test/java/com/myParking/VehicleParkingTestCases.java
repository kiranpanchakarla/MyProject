package com.myParking;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

public class VehicleParkingTestCases {

	static ParkingService parkingService;
	static int numSlots = 6;
	
	@BeforeClass
    public static void setup()
    {
		parkingService = new ParkingServiceImpl();
    }
	@Test
    public void park() throws Exception
    {
        parkingService.createParkingLot(6);
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
        assertEquals(5,slotId);
        System.out.println("Allocated slot number:" + slotId);

        slotId = parkingService.park(new Vehicle("KA-01-HH-3141", "Black"));
        assertEquals(6, slotId);
        System.out.println("Allocated slot number:" + slotId);
    }

	 

}
