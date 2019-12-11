package com.company;
import  com.company.Category;
import  com.company.Datasource;
import  com.company.Product;

import javax.naming.ldap.PagedResultsControl;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {

        Datasource ds = new Datasource();

        if (ds.open()) {

            String text = "connected to db\n";
            int j;
            for(j = 0; j < text.length(); j++){
                System.out.printf("%c", text.charAt(j));
                try{
                    Thread.sleep(20);//0.5s pause between characters
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }

            }
        } else {
            System.out.println("not connected to db");
        }

        int b = 1;
        while (b==1){
            System.out.println("\u001B[32m"+"c to Insert into Database \nr to Show Database \nu to Update  \nd to Delete \ne to Exit "+"\u001B[37m");
            Scanner myObj = new Scanner(System.in);
            String Menu = myObj.nextLine();
            switch (Menu){
                case "c":
                    System.out.println("\n\nInserting ");
                    System.out.println("[1-cusmtomer\t2-product and category] ");
                    Scanner myObj2 = new Scanner(System.in);
                    int InsertMenu = myObj2.nextInt();
                    switch (InsertMenu){

                         case 1:

                             try {
                                 System.out.println("Customer name");
                                 String name = myObj.nextLine();
                                 System.out.println("Customer email");
                                 String email = myObj.nextLine();
                                 System.out.println("Customer address");
                                 String address = myObj.nextLine();
                                 System.out.println("Customer phone");
                                 String phone = myObj.nextLine();
                                 ds.insertCustomer(name,email,address,phone);

                             }catch (SQLException e){
                                 System.out.println(e.getMessage());
                             }
                             break;
                         case 2:



                               try {
                                   out.println("Product`s name");
                                   String Pname = myObj.nextLine();
                                   out.println("Product`s description");
                                   String Pdes = myObj.nextLine();
                                   out.println("Product`s Price");
                                   double price = myObj.nextDouble();
                                   myObj.nextLine();
                                   out.println("Product`s category");
                                   String category = myObj.nextLine();
                                   out.println("Sub Category ID");
                                   int subCatID = myObj.nextInt();
                                   ds.insertProductCategory(Pname,Pdes,price,1,category,subCatID);

                               } catch (SQLException e){
                                   System.out.println(e.getMessage());
                               }




                               break;
                    }
                    break;
                case "r":
                    System.out.println("\n\nReading from Database ");
                    System.out.println("press :\n" +
                            " 1 to see Products Info\n" +
                            "2 to see Customers Info");
                    Scanner myObj3 = new Scanner(System.in);
                    int Menu2 = myObj.nextInt();
                    if(Menu2==1){
                    ds.queryProductCategoryCurrencies();}
                    else if(Menu2== 2){


                        ds.queryCustomers();
                    }
                    break;
                case "u":
                    System.out.println("\n\nUpdating  ");
                    System.out.println("Press : 1 - Update products \nPress : 2 - Update customers");


                    int userChoice1 = myObj.nextInt();
                    myObj.nextLine();

                    switch (userChoice1) {
                        case 1: {

                            System.out.println("productName : ");
                            String productName = myObj.nextLine();
                            System.out.println("productPrice : ");
                            double productPrice = myObj.nextDouble();
                            myObj.nextLine();
                            try {
                                ds.updateProducts(productName, productPrice);
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        }

                        case 2: {

                            System.out.println("Current customer`s Email : ");
                            String customerEmail = myObj.nextLine();
                            System.out.println("Type customer New Name : ");
                            String customerNewName = myObj.nextLine();
                            try {
                                ds.updateCustomers(customerEmail, customerNewName);
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        }
                    }
                    break;
                case "d":
                    System.out.println("\n\nDelete\n Press 1 to delete a customer \t 2 to delete product ");
                    int dMenu = myObj.nextInt();
                    myObj.nextLine();
                    if (dMenu == 2) {
                        System.out.println("type Product`s name");

                        String Deleter = myObj.nextLine();

                        try {
                            ds.deletingProducts(Deleter);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else if (dMenu == 1){
                        System.out.println("Type Customer`s Email");
                            String Deleter2 = myObj.nextLine();

                            try {
                                ds.deletingCustomer(Deleter2);
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                    }
                    break;
                case "e":
                    b=0;
                    break;
                default:
                    System.out.println("\n\nNot in the menu");
                    break;
            }
        }
        ds.close();

    }

}
