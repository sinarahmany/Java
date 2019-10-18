package com.company;
import java.util.Scanner;

public class Second {
    //double Numbers[] ;
    public static boolean vj(){
    int x;
    System.out.println("Enter an integer to check if it is odd or even");
    Scanner in = new Scanner(System.in);
    x = in.nextInt();

    if (x % 2 == 0){
        System.out.println("The number is even.");
        return true;}
    else{
        System.out.println("The number is odd.");
        return false;}
    }

}
