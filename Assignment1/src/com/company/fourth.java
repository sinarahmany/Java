package com.company;

import java.util.Scanner;

public class fourth {
    public static int i, Sum = 0;

    public boolean Perfect(int Number) {
        for (i = 1; i < Number; i++) {
            if (Number % i == 0) {
                Sum = Sum + i;
            }
        }

        if (Sum == Number) {
            for(int l=1;l<Number;l++)
            {
                if (Number % l == 0)
                {
                    System.out.print(l+" ");
                }
            }
            //System.out.format("\n "+ Number +" is a Perfect Number\n");
            return true;
        } else {
            return false;
            //System.out.format("\n"+ Number +" is NOT a Perfect Number\n");
        }
    }

}
