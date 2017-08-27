package com.carrace;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HashMap<String, ArrayList> vehicles = createVehicles();
        simulateRace(vehicles);
        printRaceResults(vehicles);
    }

    public static boolean isRaining(int percent) {
        Random chance = new Random();

        return chance.nextInt(100) <= percent;
    }

    public static HashMap<String, ArrayList> createVehicles(){
        HashMap<String, ArrayList> vehicles = new HashMap<>(3);

        ArrayList<Car> cars = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Car newCar = new Car();
            cars.add(newCar);
        }
        vehicles.put("cars", cars);

        ArrayList<Motorcycle> motorcycles = new ArrayList<>();
        for (int i = 1; i <= Motorcycle.nameNumber; i++) {
            Motorcycle newMotorcycle = new Motorcycle(i);
            motorcycles.add(newMotorcycle);
        }
        vehicles.put("motorcycles", motorcycles);

        ArrayList<Truck> trucks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Truck newTruck = new Truck();
            trucks.add(newTruck);
        }
        vehicles.put("trucks", trucks);

        return vehicles;
    }

    public static void simulateRace(HashMap<String, ArrayList> vehicles) {
        for (int i = 0; i < 50; i++) {
            boolean wetAsphalt = isRaining(30);

            ArrayList<Car> cars = vehicles.get("cars");

            for (Car car : cars) {
                int distance;
                distance = wetAsphalt ? car.getInRainSpeed() : car.getNormalSpeed();
                car.moveForAnHour(distance);
            }

            ArrayList<Truck> trucks = vehicles.get("trucks");

            for (Truck truck : trucks) {
                int distance;
                distance = wetAsphalt ? truck.getInRainSpeed() : truck.getNormalSpeed();
                truck.moveForAnHour(distance);
            }

            ArrayList<Motorcycle> motorcycles = vehicles.get("motorcycles");

            for (Motorcycle motorcycle : motorcycles) {
                int distance;
                distance = wetAsphalt ? motorcycle.getInRainSpeed() : motorcycle.getNormalSpeed();
                motorcycle.moveForAnHour(distance);
            }
        }
    }

    public static void printRaceResults(HashMap<String, ArrayList> vehicles) {
        System.out.println("\nCars race after 50 hours in order:\n");
        ArrayList<Car> cars = vehicles.get("cars");
        for (Car car : cars) {
            car.printResults();
        }

        System.out.println("\nMotorcycles race after 50 hours in order:\n");
        ArrayList<Motorcycle> motorcycles = vehicles.get("motorcycles");
        for (Motorcycle motorcycle : motorcycles) {
            motorcycle.printResults();
        }

        System.out.println("\nTrucks race after 50 hours in order:\n");
        ArrayList<Truck> trucks = vehicles.get("trucks");
        for (Truck truck : trucks) {
            truck.printResults();
        }
    }


}
