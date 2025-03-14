package com.codurance.ocp;

public class Manager extends Employee implements Payable {

    private int bonus;

    public Manager(int salary, int bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public int payAmount() {
        return salary + bonus;
    }
}
