package com.sda.spring.boot.rest.autowired;

public class SpellChecker implements ISpellChecker {

    @Override
    public String checkSpelling() {
        System.out.println("checking");
        return "checking";
    }
}
