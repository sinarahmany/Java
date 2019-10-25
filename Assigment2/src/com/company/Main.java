package com.company;

import com.company.calculator.Calculator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.Subtract(20,5));
        System.out.println(cal.Divide(20,5));
        System.out.println(cal.Add(20,5));
        System.out.println(cal.Multi(20,5));

        System.out.println("\n-------------------------------");
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Cylinder(2.4 , 4.7 ));
        shapeList.add(new Cylinder(4.2 , 5 ));
        shapeList.add(new Cylinder(5.3 , 7 ));
        shapeList.add(new Cylinder(2 , 4.7 ));
        shapeList.add(new Cylinder(7 , 7.1 ));

        double AreaAdd=0 ;
        int counter=1;
        //printing the volume and surface area using for each loop
        for(Shape shape: shapeList){
            System.out.println("\nCylinder number : "+counter + "\nsurface area: ");
            System.out.format("%.2f",shape.surface());
            System.out.println("\nvolume area: ");
            System.out.format("%.2f",shape.volume());
            //getting sum of the surfaces
            AreaAdd = cal.Add(shape.surface(),AreaAdd);
            counter++;
            System.out.println("\n-------------------------------");
        }
        //printing the sum of the surfaces
        System.out.format("\n\nThe total sum of all the Cylinder area`s is = %.2f" , AreaAdd);
    }
}
