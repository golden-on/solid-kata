package com.codurance.dip;

import java.time.MonthDay;

public class Clock implements ToDayable {

    @Override
    public MonthDay monthDay() {
        return MonthDay.now();
    }
}