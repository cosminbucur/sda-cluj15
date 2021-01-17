package com.sda.fundamentals;

public class DemoSwitch {

    public static void main(String[] args) {
        mySwitch(4);
    }

    public static void mySwitch(int selectedOption) {
        switch (selectedOption) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("unknown option");
        }
    }
}
