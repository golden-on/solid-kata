package com.codurance.lsp;

public class ElectricCar extends Vehicle implements Chargable {

    private static final int BATTERY_FULL = 100;
    private int batteryLevel;

    public void chargeBattery() {
        batteryLevel = BATTERY_FULL;
    }

    public int batteryLevel() {
        return batteryLevel;
    }
}
