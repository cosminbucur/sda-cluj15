package com.sda.fundamentals;

import java.util.Objects;

// abstraction of a real object
public class Car {

    // static variable
    public static final int TEMPERATURE = 20;   // constant

    // instance / state variable
    private String color;

    // change state
    // 1. constructor
    public Car(String color) {
        if (color.isEmpty()) {
            this.color = "gray";
        }
        this.color = color;
    }

    // default constructor
    public Car() {

    }

    public String getColor() {
        return color;
    }

    // 2. setter
    public void setColor(String color) {
        this.color = color;
    }

    // this = myObject1, otherObject = myObject2
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car otherCar = (Car) object;
        return Objects.equals(this.color, otherCar.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "my color is: " + color;
    }
}
