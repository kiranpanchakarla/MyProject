package com.myParking.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	private Map<ParkingArea, Vehicle> parkingAreaMap;
	private Map<String, List<Vehicle>> vehicleColorMap;
	private Map<String, ParkingArea> registrationNumberSlotMap;

	PriorityQueue<Integer> getFreeArea = new PriorityQueue<Integer>();
	Vehicle vehicleList[];
	
	public ParkingServiceImpl() {
		parkingAreaMap = new HashMap<ParkingArea, Vehicle>();
		vehicleColorMap = new HashMap<String, List<Vehicle>>();
		registrationNumberSlotMap = new HashMap<String, ParkingArea>();
	}

	public void createParkingLot(int capacity) {

		  for (int c = 1; c <= capacity; c++) {
			//parkingAreaMap.put(new ParkingArea(c), null);

			getFreeArea.add(c);
		}  
		vehicleList = new Vehicle[capacity];
		 
	}

	public int park(Vehicle vehicle) {
		// Get the free slot nearest to entrance
		int areaId = getFreeSlot();
		/*if (areaId > 0) {
			ParkingArea pa = new ParkingArea(areaId);
			parkingAreaMap.put(pa, vehicle);
			addTovehicleColorMap(vehicle);
			addToRegistrationNumberSlotMap(vehicle, pa);
		} else {
			System.out.println("Sorry, parking lot is full");
		}*/

		// id is -1 when the parkinglot is full
		if (areaId > 0) {
		vehicleList[areaId-1] = vehicle;
		}else {
			System.out.println("Sorry, parking lot is full");
		}
		return areaId;
		
		 

	}


	private int getFreeSlot() {
		if (getFreeArea.size() > 0) {
			return getFreeArea.poll();
		} else
			return -1;
	}

	public int leave(int areaId) {
		/*Vehicle vehicle = parkingAreaMap.get(new ParkingArea(areaId));
		parkingAreaMap.put(new ParkingArea(areaId), null);
		//removeColorVehicleListMap(vehicle);
		//removeFromRegistrationNumberSlotMap(vehicle);

		// Add it to free slots
		getFreeArea.add(areaId);*/
		
		vehicleList[areaId-1] = null;
		getFreeArea.add(areaId);
		return areaId;
	}

	public Vehicle[] getParkinglotStatus() {
		return this.vehicleList;
	}

	private void addTovehicleColorMap(Vehicle vehicle) {
		String color = vehicle.getColor();
		List<Vehicle> vehicleList = vehicleColorMap.get(color);
		if (vehicleList == null) {
			vehicleList = new ArrayList<Vehicle>();
			vehicleList.add(vehicle);
			vehicleColorMap.put(color, vehicleList);
		} else {
			vehicleList.add(vehicle);
		}

	}

	public List<Vehicle> getRegistrationNumbers(String color) {
		return vehicleColorMap.get(color);
	}

	private void addToRegistrationNumberSlotMap(Vehicle vehicle, ParkingArea pa) {
		registrationNumberSlotMap.put(vehicle.getRegistrationNo(), pa);
	}

	public ParkingArea getSlotForVehicle(String registrationNumber) {
		if (registrationNumberSlotMap.containsKey(registrationNumber))
			return registrationNumberSlotMap.get(registrationNumber);
		else
			return null;
	}

	public List<ParkingArea> getSlots(String color) {
		List<Vehicle> vehicle = vehicleColorMap.get(color);
		List<ParkingArea> pa = new ArrayList<ParkingArea>();
		for (Vehicle vel : vehicle) {
			ParkingArea parkingArea = registrationNumberSlotMap.get(vel.getRegistrationNo());
			pa.add(parkingArea);
		}
		return pa;
	}

	private void removeColorVehicleListMap(Vehicle vehicle) {
		String color = vehicle.getColor();
		List<Vehicle> vehicleList = vehicleColorMap.get(color);
		if (vehicleList == null) {

		} else {
			vehicleList.remove(vehicle);
		}
	}
	
	private void removeFromRegistrationNumberSlotMap(Vehicle vehicle)
    {
        registrationNumberSlotMap.remove(vehicle.getRegistrationNo());
    }

	@SuppressWarnings("null")
	public String[] getVehicleByColor(String color) {
		String[] vehicleNumbers = new String[vehicleList.length];
		
		for(int i=0; i<vehicleList.length ;i++) {
			if(vehicleList[i].getColor().equals(color)) {
				vehicleNumbers[i] = vehicleList[i].getRegistrationNo();
			}
			
		}
		
		return vehicleNumbers;

       
	}
}
