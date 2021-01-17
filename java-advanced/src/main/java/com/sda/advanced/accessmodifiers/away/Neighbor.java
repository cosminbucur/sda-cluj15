package com.sda.advanced.accessmodifiers.away;

import com.sda.advanced.accessmodifiers.home.Parent;

public class Neighbor {

    public void hasAccessTo() {
        Parent parent = new Parent();
        System.out.println(parent.phoneNo);
    }
}
