package com.company.calculator;

public class Calculator {
    //used static cause the pi is always 3.14 and it never changes
     public static final double  pi = 3.14 ;

    //add method
   public static double Add(double ... x ){
        double result = 0;
        for(int i = 0; i<x.length;i++){
            result += x[i];
        }
        return result ;
    }

    //subtract method
    public static double Subtract(double ... x ){
       //we use the if else here in case our input is null or there is no input
        double result = 0;
        if(x.length == 0){
            return result;
        }else {
        double a = x[0];
        for(int i = 1; i<x.length;i++){
            result -= x[i];
        }
        return result+a ;}
    }
    //multiply method
    public static double Multi(double ... x ){
        double result = 1;
        for(int i = 0; i<x.length;i++){
            result *= x[i];
        }
        return result ;
    }
    //divide method
    public static double Divide(double ... x ){
        double result = 0;
        if(x.length == 0 ){
            return result;
        }else {
            double a = x[0];
            for(int i = 1; i<x.length;i++){
                if(x[i] == 0){return  0 ;}
                a /= x[i];
            }
            return a ;}
    }

}
