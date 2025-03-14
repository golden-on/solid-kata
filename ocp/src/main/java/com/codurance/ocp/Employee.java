package com.codurance.ocp;

public class Employee {

    protected int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    // public int payAmount() {
    //     switch (this.type) {
    //         case ENGINEER:
    //             return salary;
    //         case MANAGER:
    //             return salary + bonus;
    //         default:
    //             return 0;
    //     }
    // }

}