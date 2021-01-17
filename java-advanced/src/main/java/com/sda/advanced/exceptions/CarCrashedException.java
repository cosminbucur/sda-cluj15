package com.sda.advanced.exceptions;

public class CarCrashedException extends Exception {

    public CarCrashedException(Car car) {
        super("car " + car + " crashed at speed " + car.getSpeed());
    }
}
