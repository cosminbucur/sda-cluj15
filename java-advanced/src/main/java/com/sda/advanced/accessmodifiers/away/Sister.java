package com.sda.advanced.accessmodifiers.away;

import com.sda.advanced.accessmodifiers.home.Parent;

public class Sister extends Parent {

    public void hasAccessTo() {
        System.out.println(super.wealth);
        System.out.println(super.phoneNo);

        super.cleanHouse();
    }


}
