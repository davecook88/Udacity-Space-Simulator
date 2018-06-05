package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Rocket implements SpaceShip {
    private int maxWeight;
    private int currentWeight;
    private int cost;
    private double chanceOfLaunchExplosion;
    private double chanceOfLandingCrash;
    private ArrayList cargo = new ArrayList();

    Rocket(int maxWeight, int currentWeight, int cost) {
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    void setChanceOfLandingCrash(double chanceOfLandingCrash) {
        this.chanceOfLandingCrash = chanceOfLandingCrash * ((float) this.currentWeight/this.maxWeight);
    }

    void setChanceOfLaunchExplosion(double chanceOfLaunchExplosion) {
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion * ((float) this.currentWeight/this.maxWeight);
    }

    public double getChanceOfLandingCrash() {
        return chanceOfLandingCrash;
    }

    public double getChanceOfLaunchExplosion() {
        return chanceOfLaunchExplosion;
    }

    @Override
    public boolean launch() {
        int r = Main.getRandom().nextInt(100);
        boolean b = r/ this.chanceOfLandingCrash  < 100;
        return b;
}

    @Override
    public boolean land() {
        int r = Main.getRandom().nextInt(100);
        boolean b =  r / this.chanceOfLandingCrash < 100;
        return b;
    }

    @Override
    public boolean canCarry(Item item) {
        if (item.weight + currentWeight < maxWeight) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {
        this.cargo.add(item);
        currentWeight += item.weight;
    }
}
