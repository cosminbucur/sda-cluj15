package com.sda.fundamentals.objects;

import java.time.LocalDate;
import java.util.Date;

public class DemoVariables {

    // primitives
    int age;    // default 0
    boolean isAvailable;    // default false
    double price = 20.3d;   // default 0.0
    long timestamp = 1610789756L;     // default 0L

    // wrapper types
//    Integer integer = Integer.valueOf(10); // unnecessary boxing
    Integer integer = 10;

    // objects
    String myName = "paul";
    Date date = new Date();
    LocalDate today = LocalDate.now();
    LocalDate localDate = LocalDate.of(2021, 1, 10);
}
