package com.codurance.lsp;

public class FillingStation{

    public void refuel(Fuellable vehicle) {
        vehicle.fillUpWithFuel();
    }

    public void charge(Chargable vehicle) {
        vehicle.chargeBattery();
    }
}
