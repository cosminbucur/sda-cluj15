package com.sda.spring.boot.rest.autowired;

public class SpellCheckerImproved implements ISpellChecker {

    @Override
    public String checkSpelling() {
        System.out.println("checking better");
        return "checking better";
    }
}
