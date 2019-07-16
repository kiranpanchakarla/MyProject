package com.myParking;

import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static ParkingService parkingService;
	
	
    public static void main( String[] args )
    {
    	parkingService = new ParkingServiceImpl();
    	
    	create_parking_lot(6);
    	park("KA01HH1234","White");
    	park("KA01HH9999","White");
    	park("KA01BB0001","Black");
    	park("KA01HH7777","Red");
    	park("KA01HH2701","Blue");
    	park("KA01HH3141","Black");
    	park("KA01HH3142","Black");
    }
    
    private static void create_parking_lot(int nrOfSlots)
    {
    	parkingService.createParkingLot(nrOfSlots);
        System.out.println("Created a parking lot with " + nrOfSlots + " slots");
    }
    
    private static void park(String registrationNumber, String color)
    {
         
            int areaId = parkingService.park(new Vehicle(registrationNumber, color));
            if(areaId >0)
            System.out.println("Allocated slot number: " + areaId);
        
        
    }
}
