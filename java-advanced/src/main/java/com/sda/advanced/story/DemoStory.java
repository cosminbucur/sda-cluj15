package com.sda.advanced.story;

public class DemoStory {

    public static void main(String[] args) {
        Love love1 = new Love();
        FinancialSecurity financialSecurity1 = new FinancialSecurity();
        Andreea andreea = new Andreea(love1, financialSecurity1);

        Pony fakePony = null;

//        andreea.pleaseGiveMeAPony(fakePony);
//        andreea.feedPony();

        Pony realPony = new Pony("Dixie");
        andreea.pleaseGiveMeAPony(realPony);
        andreea.feedPony();


//        Love love2 = new Love();
//        FinancialSecurity financialSecurity2 = new FinancialSecurity();
//        Woman stefania = new Stefania(love2, financialSecurity2);
    }
}
