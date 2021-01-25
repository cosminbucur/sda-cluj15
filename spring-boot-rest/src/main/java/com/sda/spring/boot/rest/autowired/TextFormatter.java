package com.sda.spring.boot.rest.autowired;

public class TextFormatter implements ITextFormatter {

    @Override
    public void formatText() {
        System.out.println("formatting");
    }
}
