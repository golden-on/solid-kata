package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final ToDayable clock;
    private final Sendable emailSender;

    public BirthdayGreeter(EmployeeRepository employeeRepository, ToDayable clock, Sendable emailSender) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
        this.emailSender = emailSender;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(employee -> emailFor(employee))
                .forEach(email -> emailSender.send(email));
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}