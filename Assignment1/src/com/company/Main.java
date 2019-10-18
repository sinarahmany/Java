package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        int Mflag = 0;
        while(Mflag==0) {
        System.out.println("each assigment has it`s own number type the number of the assignment you want to check(NOT IN ALPHABET PLZ!!!)");
        Scanner inpu = new Scanner(System.in);
        String ChooserUser2 = inpu.next();

            switch (ChooserUser2) {

                case "1":

                    int count = 1;
                    int Flag = 0;
                    while (Flag == 0) {
                        System.out.println("Customer Number " + count + "\n");
                        One Customer = new One();
                        Customer.Calculate_Charges();
                        System.out.println("[ Press 'n' to Exit ] / [ Any other key to continue ]");
                        Scanner input = new Scanner(System.in);
                        String ChooserUser = input.next();
                        if (ChooserUser.equals("n")) {
                            Flag = -1;
                            //System.exit(0);
                        }
                        count++;
                        System.out.println("******************************************************\n");
                    }

                    break;
                case "2":
                    Second two = new Second();
                    two.vj();

                    break;
                case "3":
                    third ob = new third();
                    Scanner ob1 = new Scanner (System.in);
                    int hr, mi, se;
                    System.out.println("Enter time in 12 hour format. First enter Hours then minutes and then seconds");
                    hr=ob1.nextInt();
                    mi=ob1.nextInt();
                    se=ob1.nextInt();
                    ob.time(hr,mi,se);
                    break;
                case "4" :
                    fourth d = new fourth();
                    int j;
                    for(j=1; j<1001 ; j++){
                        d.Sum=0;
                        if(d.Perfect(j)){
                            System.out.print("=>"+j);
                            System.out.println("\n");

                        }


                    }
                    break;
                case "exit" :
                    System.out.println("You exited the program");
                    Mflag = -1 ;
                    break;
                default:
                    System.out.println("Not in the menu");
                    break;
            }
        }


    }
}
