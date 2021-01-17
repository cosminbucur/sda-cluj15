package com.sda.advanced.exceptions;

public class DemoExceptions {

    public static void main(String[] args) {
        Car car = new Car();
        try {
            car.increaseSpeed();    // 50
            car.increaseSpeed();    // 100
            car.increaseSpeed();    // 150
            car.increaseSpeed();    // exception
        } catch (CarCrashedException e) {
            System.out.println("call ambulance");
        }
    }
}
