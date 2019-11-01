package com.company;
import java.util.ArrayList;
import java.util.List;
public class Customer extends Staff implements Iorder {
    private List<Item> items ;
    private int customerID;
    private double addTips(){return 0;};
    public void makeOrder(List<Item>items){};
    public void billRequest(){};
    public double payBill(){return 0;};

    public List<Item> getItems() {
        return items;
    }

    ;

    public void makereservayion(){};
    public boolean sit(){return false;};
    public void eatfood(){};
    public void addItem(){};
    public void removeItem(){};

    @Override
    public void Takeorder(List<Item>items,int CustomerID) {

    }

    @Override
    public List sendOrder() {
        return null;
    }

    @Override
    public void clean() {

    }

}
