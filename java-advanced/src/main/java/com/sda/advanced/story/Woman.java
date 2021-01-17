package com.sda.advanced.story;

public abstract class Woman {

    // HAS
    public Love love;
    public FinancialSecurity financialSecurity;

    // NEEDS (composition)
    public Woman(Love love, FinancialSecurity financialSecurity) {
        this.love = love;
        this.financialSecurity = financialSecurity;
    }

    public abstract void feel();

    public abstract void dream();

    public abstract void relax();

    public void drive() {
        System.out.println("driving");
    }
}
