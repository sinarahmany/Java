package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void getRadius() {
        Cylinder cc =  new Cylinder(2.4 , 4.7 );
        assertEquals(4.7,cc.getRadius());
    }

    @Test
    void getHeight() {
      Cylinder cc =  new Cylinder(2.4 , 4.7 );
      assertEquals(2.4,cc.getHeight());
    }

    @Test
    void setRadius() {
        Cylinder cc =  new Cylinder(2.4 , 4.7 );
        cc.setRadius(5.5);
        assertEquals(5.5,cc.getRadius());
    }

    @Test
    void setHeight() {
        Cylinder cc =  new Cylinder(2.4 , 4.7 );
        cc.setHeight(6.5);
        assertEquals(6.5,cc.getHeight());
    }

    @Test
    void surface() {
        Cylinder cc =  new Cylinder(1.00 , 2 );
        assertEquals(37.68,cc.surface());
    }

    @Test
    void volume() {
        Cylinder cc =  new Cylinder(1.00 , 2 );
        assertEquals(12.56,cc.volume());
    }
}