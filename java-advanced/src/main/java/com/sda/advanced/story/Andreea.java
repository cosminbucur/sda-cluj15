package com.sda.advanced.story;

public class Andreea extends Woman implements Polyglot, Developer {

    private Pony pony;

    public Andreea(Love love, FinancialSecurity financialSecurity) {
        super(love, financialSecurity);
    }

    public Pony pleaseGiveMeAPony(Pony myNewPony) {
        if (myNewPony == null) {
            System.out.println("hey, you promised!");
            System.out.println("give me a real pony!");
        } else {
            System.out.println("Yey, now I can die happy!");
            this.pony = myNewPony;
        }

        return pony;
    }

    public void feedPony() {
        System.out.println("here's an apple mr " + pony.getName());
        pony.eat();
    }

    @Override
    public void feel() {
        System.out.println("feeling tired");
    }

    @Override
    public void dream() {

    }

    @Override
    public void relax() {

    }

    public void haveFun() {
        System.out.println("having fun");
    }

    public void getTanned() {
        System.out.println("having fun");
    }

    public void getNailsDone() {
        System.out.println("ouch I broke a nail");
    }


    @Override
    public void speakEnglish() {

    }

    @Override
    public void speakSpanish() {

    }

    @Override
    public void writeCode() {

    }
}
