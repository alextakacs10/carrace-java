package com.carrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Motorcycle {

    static public int nameNumber = 10;
    private String name;
    private Integer distanceTraveled;
    private int speed;
    private ArrayList<Integer> speedEveryHour;

    public Motorcycle(int number) {
        this.name = "Motorcycle " + number;
        this.distanceTraveled = 0;
        this.speed = 100;
        this.speedEveryHour = new ArrayList<>();
    }

    public void moveForAnHour(int distance) {
        this.distanceTraveled += distance;
        this.speedEveryHour.add(distance);
    }

    public int getNormalSpeed() {
        return speed;
    }

    public int getInRainSpeed() {
        return speed - reduceSpeedBy();
    }

    private int reduceSpeedBy() {
        Random newRandom = new Random();
        int max = 50;
        int min = 5;
        int range = max - min + 1;
        int reduceSpeedBy =  newRandom.nextInt(range) + min;

        return reduceSpeedBy;
    }

    public void printResults() {
        System.out.printf("%s '%s' drove %,d km/s. Lowest speed: %s. Average speed: %s.%n",
                (this.getClass().toString()).replace("class ", ""),
                this.name, this.distanceTraveled, Collections.min(this.speedEveryHour), getAverageSpeed());
    }

    private Integer getAverageSpeed() {
        int sum = 0;
        for (Integer n : this.speedEveryHour) {
            sum += n;
        }
        return sum / this.speedEveryHour.size();
    }
}
