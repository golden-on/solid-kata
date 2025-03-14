package com.codurance.isp;

public class Dog implements Runing, Barking {
    public void run() {
        System.out.print("Dog is running");
    }

    public void bark() {
        System.out.print("Dog is barking");
    }
}
