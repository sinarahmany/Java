package com.company;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
//type psvm and hit tab the line below will appear
//cntrl+D  for duplicating
    public static void main(String[] args) {
        String anyName = "Taylor";
        System.out.println("Hello "+ anyName);
        String UserInput = "entertainment";
        System.out.println("Contains : "+UserInput.contains("enter"));

        int counter=0;
        String str1 = Integer.toString(counter);



        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
        JLabel welcome = new JLabel(str1);
        for(int i=0;i<5;i++){
            counter=i;
            System.out.println(counter);
            frame.getContentPane().add(welcome);
        }
        frame.setVisible(true);
    }
}
