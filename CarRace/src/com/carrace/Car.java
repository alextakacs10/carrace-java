package com.carrace;

import java.util.ArrayList;
import java.util.Random;

public class Car {
    static final String[] CAR_NAMES = {
            "Mastery", "Scorpion", "Tradition", "Revelation", "Prospect",
                "Crux", "Epiphany", "Orbit", "Starlight", "Charm"
    };

    private String name;
    private int normalSpeed;
    private int inRainSpeed;
    private Integer distanceTraveled;
    private ArrayList<Integer> speedEveryHour;

    public Car() {
        this.name = selectName();
        this.normalSpeed = calibrateSpeed();
        this.inRainSpeed = 70;
        this.distanceTraveled = 0;
        this.speedEveryHour = new ArrayList<>();
    }

    private String selectName() {
        Random newRandom = new Random();
        int prefix = newRandom.nextInt(10);
        int suffix;
        do {
            suffix = newRandom.nextInt(10);
        } while (prefix == suffix);

        String selectedName = (CAR_NAMES[prefix] + " ").concat(CAR_NAMES[suffix]);

        return selectedName;
    }

    private int calibrateSpeed() {
        Random newRandom = new Random();
        int max = 110;
        int min = 80;
        int range = max - min + 1;
        int randomSpeed =  newRandom.nextInt(range) + min;

        return randomSpeed;
    }

    public void moveForAnHour(int distance) {
        this.distanceTraveled += distance;
        this.speedEveryHour.add(distance);
    }

    public int getNormalSpeed() {
        return this.normalSpeed;
    }

    public int getInRainSpeed() {
        return this.inRainSpeed;
    }

    public void printResults() {
        System.out.printf("%s '%s' drove %,d kms. Calibrated speed: %s. Average speed: %s.%n",
                (this.getClass().toString()).replace("class ", ""),
                this.name, this.distanceTraveled, this.normalSpeed, getAverageSpeed());
    }

    private Integer getAverageSpeed() {
        int sum = 0;
        for (Integer n : this.speedEveryHour) {
            sum += n;
        }
        return sum / this.speedEveryHour.size();
    }
}
