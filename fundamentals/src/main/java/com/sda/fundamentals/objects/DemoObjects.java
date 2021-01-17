package com.sda.fundamentals.objects;

import com.sda.fundamentals.Car;

public class DemoObjects {

    public static void main(String[] args) {
        Car car1 = new Car("blue");
        // MyObject = class
        int temperature1 = Car.TEMPERATURE;    // call static
//        myObject1.color = "blue";

        // type reference = new constructor
        // assignment = instantiation
        Car car2 = new Car("red");
        int temperature2 = Car.TEMPERATURE;

        // myObject2 = instance
//        myObject2.color = "red";
        car2.setColor("green");

        Car car3 = new Car();

        Car car4 = new Car("");

        car1.equals(car2);
        car1.equals(null);

        System.out.println(car2.toString());
    }
}
