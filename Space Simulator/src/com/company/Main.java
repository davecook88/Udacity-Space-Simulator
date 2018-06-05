package com.company;

import java.util.Random;

public class Main {

    private static Random random;

    public static void main(String[] args) {
	// write your code here
        random = new Random();

        Simulation sim = new Simulation();
        for (int i = 1; i < 3; i++) {
            System.out.println(sim.runSimulation(i));
        }
    }

    public static Random getRandom() {
        return random;
    }
}
