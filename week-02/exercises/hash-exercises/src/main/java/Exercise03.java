import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise03 {

    // 1. Create a method to print all Vehicles in a HashMap<String, Vehicle>.
    // Consider making it `public` so you can use it in other exercises.
    public static void printAll(HashMap<String, Vehicle> vehicleMap) {
        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.printf("Vehicle: %s %s %s %S Vin: %s%n", vehicle.getColor(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVin());
        }


    }

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();
        printAll(vehicleMap);

        // 2. Print `vehicleMap` using your "print all" method.
    }
}

