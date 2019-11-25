package com.company.Classroom;

public class Dimension {

    private double length;
    private double width;
    private double height;

    public Dimension() {
        this(0, 0, 0);
    }

    public Dimension(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Dimension(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
