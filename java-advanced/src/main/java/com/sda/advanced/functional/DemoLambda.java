package com.sda.advanced.functional;

public class DemoLambda {

    public static void main(String[] args) {
        // anonymous implementation (class)
        OneParam myInterfaceWithOneParam = new OneParam() {
            @Override
            public int doSomething(int number) {
                return number + 2;
            }
        };

        OneParam lambdaFunction = (number) -> {
            return number + 2;
        };

        OneParam lambdaFunctionShorter = (number) -> number + 2;

        OneParam lambdaFunctionShortest = number -> number + 2;
    }
}
