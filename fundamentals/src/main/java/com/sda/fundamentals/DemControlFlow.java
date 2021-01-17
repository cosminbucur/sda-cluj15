package com.sda.fundamentals;

public class DemControlFlow {

    public static void main(String[] args) {
        loops();
    }

    // loops
    public static void loops() {
        int[] array = {2, 3, 5, 6};

        // from to step
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

            if (array[i] == 5) {
                // get out
                break;
            }
        }
        System.out.println("out of for");

        // for each
        // element : collection
        for (int element : array) {
            System.out.println(element);
        }
    }

}
