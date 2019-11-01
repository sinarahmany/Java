package com.company;

import java.util.ArrayList;
import java.util.List;

public class Waitress extends Staff implements Iorder {
   public Waitress() {
      super();
   }

   private List <Customer>cumstomers;
   public double getBill(){return -1;};
   public List<Item> orderToChef(){return new ArrayList<>();
   };
   public void showthemenu(List<Item>items){};

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

   public List<Customer> getCumstomers() {
      return cumstomers;
   }
}
