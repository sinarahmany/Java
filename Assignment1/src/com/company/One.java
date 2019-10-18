package com.company;

import java.util.Scanner;

public class One {
    public static void Calculate_Charges(){
        System.out.println("Enter the hours of usage");
        Scanner input = new Scanner(System.in);
        double hour = input.nextDouble();
        double Cost=0;
        if(hour<=3){
            Cost = 2;
            System.out.println("The payment is " + Cost + " $");
        }
        else if(3<hour && hour<24){
            //rounding it up and convert it to int
            Cost = (( Math.ceil(hour-3))  * 0.5 ) + 2 ;
            System.out.println("The payment is " + Cost + " $");

        }
        else if(hour>24){
            Cost = 10;
            System.out.println("The payment is " +  Cost + " $");
        }
        else {
            System.out.println("type somthing");

        }
    }
}
