package com.company;

public class U1 extends Rocket {

    public U1() {
        super(18000, 0, 100);
        this.setChanceOfLandingCrash(0.01);
        this.setChanceOfLaunchExplosion(0.05);
    }

    @Override
    public void carry(Item item) {
        super.carry(item);
        setChanceOfLaunchExplosion(0.01);
        setChanceOfLandingCrash(0.05);
    }
}
