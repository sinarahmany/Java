package com.company;

public class Item {
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getIDofFood() {
        return IDofFood;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIDofFood(int IDofFood) {
        this.IDofFood = IDofFood;
    }

    private double price;
    private int IDofFood;
}
