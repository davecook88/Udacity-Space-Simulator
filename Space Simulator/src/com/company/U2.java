package com.company;

import java.util.Random;

public class U2 extends Rocket {

    public U2() {
        super(18000, 0, 120);
        this.setChanceOfLandingCrash(0.08);
        this.setChanceOfLaunchExplosion(0.04);
    }

    @Override
    public void carry(Item item) {
        super.carry(item);
        this.setChanceOfLandingCrash(0.08);
        this.setChanceOfLaunchExplosion(0.04);
    }
}
