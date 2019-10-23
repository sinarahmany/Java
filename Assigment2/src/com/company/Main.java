package com.company;

import com.company.calculator.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.Subtract(20,5));
        System.out.println(cal.Divide(20,5));
    }
}
