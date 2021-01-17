package com.sda.advanced.collections.list;

import java.util.ArrayList;
import java.util.List;

public class DemoList {

    public static void main(String[] args) {
        List<String> listOfCountries = createListOfCountries();
        printList(listOfCountries);
    }

    private static List<String> createListOfCountries() {
        // DONE: create a list of 5 countries
        List<String> countries = new ArrayList<>();

        // DONE: CREATE

        countries.add("Romania");   // 0
        countries.add("Italia");    // 1
        countries.add("Franta");    // 2
        countries.add("Germania");  // 3
        countries.add("Spania");
        countries.add("Romania");

        return countries;
    }

    private static void printList(List<String> list) {
        // element : collection
        for (String element : list) {
            System.out.println(element);
        }
    }
}
