package com.company;

public abstract class Shape {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public abstract double area();
    public abstract double perimeter();
    public Shape(){}
    public Shape(String name){
        this.name = name;
    }
}
