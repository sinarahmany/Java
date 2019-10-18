package com.company;

public class Main {

    public static void main(String[] args) {
        Square rec = new Square(50, 100);
//        rec.setHeight(100d);
//        rec.setWidth(100d);
        //if we comment the line below the output will be Square Shape
        rec.setName("This is a Square");
        System.out.println(rec.getName());

        Box aBox = new Box("metal");
        aBox.setWidth(10);
        aBox.setHeight(10);
        System.out.println(aBox.area());


    }
}
