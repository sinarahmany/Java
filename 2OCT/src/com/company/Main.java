package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Scanner is waiting for you!");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        String UpperCased = userInput.toUpperCase();
        System.out.println("\n\n\n"+"You typed "+UpperCased);
        System.out.println("Now type a number");
        Scanner scInt = new Scanner(System.in);
        int IntPut = scInt.nextInt();
        System.out.println(IntPut+" ^ 2 = "+Math.pow(IntPut,2));



    }
}
