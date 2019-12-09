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
import static java.lang.System.currentTimeMillis;
import static java.lang.System.setOut;

public class Main {

    public static void main(String[] args) {

        Datasource ds = new Datasource();

        if (ds.open()) {
            System.out.println("connected to db");
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
                    System.out.println("[1-cusmtomer \t2-product and category ");
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

                          ds.queryProductCategoryCurrencies();

                          try {

                              ds.insertProductCategory("Cookie",
                                      "cooked with chocolate and mapple syrup",
                                      2.25,
                                      1,
                                      "Snack",
                                      5);

                          } catch (SQLException e){
                              System.out.println(e.getMessage());
                          }




                          break;
                    }
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

                        List<Customer> customerList = new ArrayList<>();
                        customerList = ds.queryCustomers();

                          for(Customer i : customerList){
                              System.out.println(i.toString());
                          }
                    }
                    break;
                case "u":
                    System.out.println("\n\nUpdating  ");
                    ds.queryProductCategoryCurrencies();

                    try {

                        ds.insertProductCategory("Cookie",
                                "cooked with chocolate and mapple syrup",
                                2.25,
                                1,
                                "Snack",
                                5);

                    } catch (SQLException e){
                        System.out.println(e.getMessage());
                    }




                    break;
                case "d":
                    System.out.println("\n\nDelete ");
                    String Deleter = myObj.nextLine();
                    System.out.println(Deleter);
                    try{
                    ds.deletingProducts(Deleter);
                    } catch (SQLException e){
                            System.out.println(e.getMessage());
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
