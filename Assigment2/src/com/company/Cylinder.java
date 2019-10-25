package com.company;
import com.company.calculator.Calculator;

public class Cylinder extends Shape {
    private double radius, height ;
    //defult constructor
    public Cylinder() {this( 0 ,0 ); }

    //overloaded constructor
    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }


    //getters and setters
    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    //overriding the methods from class Shape
    @Override
    public double surface() {
        double surface = (2 * Calculator.pi * radius * height) + (2 * Calculator.pi * Math.pow(radius, 2));
        return surface;
    }
    @Override
    public double volume() {
        double volume = Calculator.pi * Math.pow(radius, 2) * height;
        return volume;
    }




}
