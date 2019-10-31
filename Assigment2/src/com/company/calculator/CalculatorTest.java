package com.company.calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        Calculator cal = new Calculator();
        assertEquals(25,cal.Add(20,5));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Calculator cal = new Calculator();
        assertEquals(15,cal.Subtract(20,5));
    }

    @org.junit.jupiter.api.Test
    void multi() {
        Calculator cal = new Calculator();
        assertEquals(100,cal.Multi(20,5));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Calculator cal = new Calculator();
        assertEquals(4,cal.Divide(20,5));
    }
}