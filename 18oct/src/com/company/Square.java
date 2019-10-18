package com.company;

import java.awt.*;

public class Square extends Shape {
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double area(){
        return height*width;
    }
    public double perimeter(){
        return 2 * (height + width ) ;
    }
    public Square(){
        this(0,0);
    }
    public Square(double height,double width){
        super("Square Shape");
        this.height = height;
        this.width = width;
    }
}
