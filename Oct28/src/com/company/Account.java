package com.company;

public class Account {
    private double Cbalance;
    private double Sbalance;

    public double getCbalance() {
        return Cbalance;
    }

    public void setCbalance(double cbalance) {
        Cbalance = cbalance;
    }

    public double getSbalance() {
        return Sbalance;
    }

    public void setSbalance(double sbalance) {
        Sbalance = sbalance;
    }

    private String name;
    public Account(){
        this("Unknown",0d,0d);
    }
    public Account(String name , double Sbalance,double Cbalance){
        this.name= name;
        this.Sbalance = Sbalance ;
        this.Cbalance = Cbalance ;
    }
    public double deposit(double Camount,double Samount){
        this.Cbalance += Camount ;
        this.Sbalance += Samount ;
        return Cbalance,Sbalance ;
    }
    public double withdrawl(double amount){
        if(this.balance < amount){
            System.out.println("sorry you can not do this");
            return this.balance;
        }
        this.balance -= amount ;
        return balance ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void TransferStoC(double amount){
        if(amount> this.Sbalance ){
            System.out.println("you don`t have enough money in your Saving acccount");

        }else
        this.Sbalance -= amount;
        this.Cbalance += amount;
        System.out.println("You Transfered "+ amount + "$ To you Checking account\n"+
                "Saving account balance : " + Sbalance + "\nChecking account balance" + Cbalance );

    }
    public void TransferCtoS(double amount){
        if(amount> this.Cbalance ){
            System.out.println("you don`t have enough money in your Checking acccount");

        }else
        this.Cbalance -= amount;
        this.Sbalance += amount;
        System.out.println("You Transfered "+ amount + "$ To you Saving account\n"+ "Saving account balance : " + Sbalance + "\nChecking account balance" + Cbalance );

    }
}
