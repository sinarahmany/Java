package com.company;

public class Main {

    public static void main(String[] args) {
	    Account account = new Account("Sina" , 500000d);
        account.deposit(39000d);
        System.out.println(account.getBalance());
    }
}
