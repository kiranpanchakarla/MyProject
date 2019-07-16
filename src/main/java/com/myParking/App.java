package com.myParking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myParking.model.ParkingArea;
import com.myParking.model.Vehicle;
import com.myParking.service.ParkingService;
import com.myParking.serviceImpl.ParkingServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	static ParkingService parkingService;

	public static void main(String[] args) {
		parkingService = new ParkingServiceImpl();

		create_parking_lot(6);
		park("KA01HH1234", "White");
		park("KA01HH9999", "White");
		park("KA01BB0001", "Black");
		park("KA01HH7777", "Red");
		park("KA01HH2701", "Blue");
		park("KA01HH3141", "Black");
		leave(4);
		status();
		park("KA01P333", "White");
		park("DL12AA9999", "White");
		/*registration_numbers_for_cars_with_colour("White");
		slot_numbers_for_cars_with_colour("White");
		slot_number_for_registration_number("KA01HH3141");
		slot_number_for_registration_number("MH04AY1111");*/
	}

	private static void create_parking_lot(int areaId) {
		parkingService.createParkingLot(areaId);
		System.out.println("Created a parking lot with " + areaId + " slots");
	}

	private static void park(String registrationNumber, String color) {

		int areaId = parkingService.park(new Vehicle(registrationNumber, color));
		if (areaId > 0)
			System.out.println("Allocated slot number: " + areaId);

	}

	private static void leave(int areaId) {
		parkingService.leave(areaId);
		System.out.println("Slot number " + areaId + " is free");
	}

	private static void status() {
		//Map<ParkingArea, Vehicle> slotCarMap = parkingService.getParkinglotStatus();
		Vehicle[] list = parkingService.getParkinglotStatus();
		System.out.println("Slot No." + "\t" + "Registration No" + "\t" + "Colour");
		//for (Map.Entry<ParkingArea, Vehicle> e : slotCarMap.entrySet()) {
		int count = 1;
		for ( Vehicle e : list) {
			if (e != null) {
				System.out.println( count +	"\t" + e.getRegistrationNo() + "\t" + e.getColor());
			}
			count++;
		}
	}

	private static void registration_numbers_for_cars_with_colour(String color) {
		List<Vehicle> vehiclesList = parkingService.getRegistrationNumbers(color);
		List<String> registrationNumbers = new ArrayList<String>();
		for (Vehicle vel : vehiclesList) {
			registrationNumbers.add(vel.getRegistrationNo());
		}
		StringBuffer sb = new StringBuffer();
		for (int c = 0; c < registrationNumbers.size(); c++) {
			sb.append(registrationNumbers.get(c));
			if (c != registrationNumbers.size() - 1) {
				sb.append(", ");
			}
		}
		System.out.println(sb.toString());
	}

	private static void slot_number_for_registration_number(String registrationNumber) {
		ParkingArea pa = parkingService.getSlotForVehicle(registrationNumber);
		if (pa == null) {
			System.out.println("Not found");
		} else {
			System.out.println(pa.getId());
		}
	}
	
	private static void slot_numbers_for_cars_with_colour(String color)
    {
        List<ParkingArea> pa =  parkingService.getSlots(color);
        StringBuffer sb = new StringBuffer();
        for(int c = 0; c < pa.size(); c++)
        {
            sb.append(pa.get(c).getId());
            if(c != pa.size()-1)
            {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
	
}
