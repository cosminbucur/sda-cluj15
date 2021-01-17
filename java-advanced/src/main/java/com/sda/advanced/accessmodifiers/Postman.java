package com.sda.advanced.accessmodifiers;

import com.sda.advanced.accessmodifiers.home.Parent;

public class Postman {

    public void hasAccessTo() {
        Parent parent = new Parent();
        System.out.println(parent.phoneNo);
    }
}
