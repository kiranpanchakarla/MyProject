package com.myParking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;
import com.myParking.util.Constants;

public class AppTest {

	static ParkingService parkingService;
	
	@BeforeClass
	public static void setup() {
		parkingService = new ParkingServiceImpl();
	}
	
	@Test
	public void testParkLeave() {
		parkingService.createParkingLot(15);
		
		 for(int c = 1; c <= 15; c++)
	        {
	            try
	            {
	            	int slotId = parkingService.park(new Vehicle("AA-10-BB-" + c, "White"));
	            	System.out.println("Allocated slot number:" + slotId);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
		 
		 parkingService.park(new Vehicle("CC-10-DD-" + 11, "White"));
		 
		 //Leave at 1,3,5 slots
		 parkingService.leave(5);
		 parkingService.leave(1);
		 parkingService.leave(3);

	}
	
	@Test
    public void testGetVehiclesByColor()
    {
		parkingService = new ParkingServiceImpl();
        parkingService.createParkingLot(15);

        for(int c = 1; c <= 10; c++)
        {
            try
            {
            	int slotId = parkingService.park(new Vehicle("EE-10-FF-" + c, "White"));
            	System.out.println("Allocated slot number:" + slotId);
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
        for(int c = 11; c <= 15; c++)
        {
            try
            {
            	int slotId = parkingService.park(new Vehicle("GG-10-HH-" + c, "Black"));
                System.out.println("Allocated slot number:" + slotId);
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
        parkingService.getDetials("White",Constants.registerColor.getConstant());
         
        parkingService.getDetials("Black",Constants.registerColor.getConstant());
    }

	@Test
    public void testGetSlotForVehicle()
    {
		parkingService = new ParkingServiceImpl();
        parkingService.createParkingLot(12);

        for(int c = 1; c <= 12; c++)
        {
            try
            {
            	int slotId =  parkingService.park(new Vehicle("KA-10-ME-" + c, "White"));
            	System.out.println("Allocated slot number:" + slotId);
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }

         parkingService.getDetials("KA-10-ME-1",Constants.slotRegister.getConstant());
         parkingService.getDetials("KA-10-ME-5",Constants.slotRegister.getConstant());
         parkingService.getDetials("KA-10-ME-10",Constants.slotRegister.getConstant());
    }

    @Test
    public void testGetSlots()
    {
    	parkingService = new ParkingServiceImpl();
        parkingService.createParkingLot(5);

        for(int c = 1; c <= 5; c++)
        {
            try
            {
                parkingService.park(new Vehicle("KA-10-ME-" + c, "White"));
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
       parkingService.getDetials("White",Constants.slotColor.getConstant());
         
    }

	
}
