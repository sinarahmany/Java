package com.company.Animals;

import com.company.Animal;
import com.company.Pet;

public class Cat implements Animal, Pet {

    @Override
    public void makeSound() {
        System.out.println("mewooo");
    }

    @Override
    public void eat() {
        System.out.println("i eat tuna");
    }

    @Override
    public void move() {
        System.out.println("i move like a Cat!!!");
    }

    @Override
    public void wash() {
        System.out.println("wash me every day");
    }

    @Override
    public void feed() {
        System.out.println("feed me every day");
    }

    @Override
    public void cuddle() {
        System.out.println("");
    }
}
