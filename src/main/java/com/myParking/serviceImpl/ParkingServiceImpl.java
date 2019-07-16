package com.myParking.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	    private Map<ParkingArea, Vehicle> parkingAreaMap;
	   // private Map<String, List<Vehicle>> vehicleMap  = new HashMap<String, List<Vehicle>>();
	    //private Map<String, ParkingArea> registrationNumberMap  = new HashMap<String, ParkingArea>();
	    
	    PriorityQueue<Integer> getFreeArea = new PriorityQueue<Integer>();
	    
	    public ParkingServiceImpl(){
	    	parkingAreaMap = new HashMap<ParkingArea, Vehicle>();
	    }

	public void createParkingLot(int capacity) {
		
		 for(int c = 1; c <= capacity; c++)
	        {
			 parkingAreaMap.put(new ParkingArea(c), null);

			 getFreeArea.add(c);
	        }
	}

	public int park(Vehicle vehicle) {
		 //Get the free slot nearest to entrance
        int areaId = getFreeSlot();
        if(areaId > 0)
        {
        	ParkingArea pa = new ParkingArea(areaId);
        	parkingAreaMap.put(pa, vehicle);
           //addToColorCarListMap(vehicle);
            //addToRegistrationNumberSlotMap(vehicle, s);
        }
        else
        {
        	System.out.println("Sorry, parking lot is full");
        }

        //id is -1 when the parkinglot is full
        return areaId;

	}

	 private int getFreeSlot()
	    {
	        if(getFreeArea.size() > 0) {
	            return getFreeArea.poll();
	        }
	        else
	            return -1;
	    }
}
