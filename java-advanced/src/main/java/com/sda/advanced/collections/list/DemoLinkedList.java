package com.sda.advanced.collections.list;

import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {

    public static void main(String[] args) {
        List<Customer> customers = new LinkedList<>();

        Customer ana = new Customer("ana");     // 0
        Customer alex = new Customer("alex");   // 1
        Customer paul = new Customer("paul");

        // create
        customers.add(ana);
        customers.add(alex);

        // read
        customers.get(1);

        // update
        customers.set(0, paul);

        // delete
        customers.remove(1);

        System.out.println(customers.size());

        customers.forEach((customer) -> {
            System.out.println(customer);
        });
    }
}
