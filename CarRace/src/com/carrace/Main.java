package com.carrace;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

    }

    public static int randomNumberInRange(int min, int max) {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }

    static boolean isRaining() {
        int moodOfMotherNature = randomNumberInRange(1, 10);

        if(moodOfMotherNature <= 7) {
            return false;
        } else {
            return true;
        }
    }

    void createVehicles() {
        for (int i = 0; i < 10; i++) {

        }
    }

    void simulateRace() {

    }

    void printRaceResults() {

    }


}
