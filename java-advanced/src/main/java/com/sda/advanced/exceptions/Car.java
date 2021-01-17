package com.sda.advanced.exceptions;

public class Car {

    private int speed;

    public void increaseSpeed() throws CarCrashedException {
        this.speed += 50;
        if (this.speed > 150) {
            throw new CarCrashedException(this);
        }
    }

    public int getSpeed() {
        return speed;
    }
}
