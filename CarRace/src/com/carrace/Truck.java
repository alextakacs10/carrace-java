package com.carrace;

import java.util.ArrayList;
import java.util.Random;

public class Truck {
    private static ArrayList<Integer> takenTruckNumbers = new ArrayList<>();

    private String name;
    private int normalSpeed;
    private int inRainSpeed;
    private Integer distanceTraveled;
    private int breakdownTurnsLeft;
    private int spentTimeAsBrokenDown;

    public Truck() {
        this.name = selectName();
        this.normalSpeed = 100;
        this.inRainSpeed = 100;
        this.distanceTraveled = 0;
        this.breakdownTurnsLeft = 0;
        this.spentTimeAsBrokenDown = 0;
    }

    private String selectName() {
        int randomID;
        do {
            Random newRandom = new Random();
            randomID =  newRandom.nextInt(1001);
        } while (takenTruckNumbers.indexOf(randomID) != -1);

        takenTruckNumbers.add(randomID);

        return String.format("%04d", randomID);
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    public int getNormalSpeed() {
        return normalSpeed;
    }

    public int getInRainSpeed() {
        return inRainSpeed;
    }

    public void moveForAnHour(int distance) {
        if (breakdownTurnsLeft < 1) {
            distanceTraveled += distance;
            if (breakDownEvent(5)) {
                breakdownTurnsLeft = 2;
                spentTimeAsBrokenDown += 2;
            }
        } else {
            breakdownTurnsLeft--;
        }
    }

    public static boolean breakDownEvent(int percent) {
        Random chance = new Random();

        return chance.nextInt(100) <= percent;
    }

    public void printResults() {
        System.out.printf("%s '%s' drove %,d km/s. Broken for %d hours.%n",
                (this.getClass().toString()).replace("class ", ""),
                this.name, this.distanceTraveled, this.spentTimeAsBrokenDown);
    }
}
