package com.company;

public class Roof {
    private double height;
    private double width;
    private String color;

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

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public boolean isIslightson() {
        return islightson;
    }

    public void setIslightson(boolean islightson) {
        this.islightson = islightson;
    }

    private int light;
    private boolean islightson;

}
