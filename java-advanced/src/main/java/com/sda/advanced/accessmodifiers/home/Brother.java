package com.sda.advanced.accessmodifiers.home;

public class Brother extends Parent {

    public void hasAccessTo() {
        System.out.println(wealth);
        System.out.println(familyToilet);
        System.out.println(phoneNo);
    }
}
