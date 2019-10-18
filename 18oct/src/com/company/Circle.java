package com.company;

public class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //no diffrence if we say the override or if we don`t say it
    @Override
    public double area() {
        return Math.PI * radius * radius ;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius ;
    }

}
