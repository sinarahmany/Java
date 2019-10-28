package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        Account account = new Account("Sina" , 50000000d);
        assertEquals(50003000,account.deposit(3000d));
    }

    @org.junit.jupiter.api.Test
    void withdrawl() {
        Account account = new Account("Sina" , 50000000d);
        assertEquals(49999999d,account.withdrawl(1));
        assertTrue(account.getBalance()>0);
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
    }

    @org.junit.jupiter.api.Test
    void setBalance() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Account account = new Account("Sina" , 50000000d);
        assertEquals("Sina",account.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        Account account = new Account("Sina" , 50000000d);
        account.setName("ss");
        assertEquals("ss",account.getName());
    }
}