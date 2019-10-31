package com.company;

public class Main {
    

    public static void main(String[] args) {

        System.out.println("Hell o");
        try {
            System.out.println(5/0);//1
        }catch (ArithmeticException e){
            System.out.println("error : " + e.getMessage());
        }
        //********************************

        try{
            String name = null;
            System.out.println(name.length());
        }catch (NullPointerException e){
            System.out.println("error : " + e.getMessage());
        }
        //*******************************
        try{
            int[] nums = {1,2,3,4,5};
            System.out.println(nums[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("error : " + e.getMessage());
        }
        finally {
            System.out.println("array index out of bounds exeption done");
            System.out.println("__________________________________");
        }
        //*****************************
        try {
            double result = divide(5,0);
            System.out.println("your first payment is " + result/2);
            System.out.println("your second payment is " + result/2);
        }catch (Exception e){

            RegularExpressions.blue("custom divide by zero exception done"+ e.getMessage());
        }finally {
            System.out.println("_____________________________");
        }
        System.out.println("The END!");

    }



    static double divide(double a,double b ){
        return a/b ;
    }
}
