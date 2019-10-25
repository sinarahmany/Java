package com.company;

public class Chair implements Iinteract {
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    private MyDimension dimension;
    private Physical physical;
    private double height;
    private double width;
    private String color;
    private String material;
    private boolean isOccupied;

    private void sit() {

    }

    public Chair(double height, double width, String color, String material, boolean isOccupied) {
        this.height = height;
        this.width = width;
        this.color = color;
        this.material = material;
        this.isOccupied = isOccupied;
    }
}
