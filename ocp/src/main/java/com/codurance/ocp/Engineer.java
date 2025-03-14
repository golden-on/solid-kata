package com.codurance.ocp;

public class Engineer extends Employee implements Payable {

    public Engineer(int salary) {
        super(salary);
    }

    @Override
    public int payAmount() {
        return salary;
    }
}
