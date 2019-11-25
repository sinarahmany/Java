package com.company;
import  com.company.Category;
import  com.company.Datasource;
import  com.company.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource ds = new Datasource();

        if (ds.open()) {
            System.out.println("connected to db");
        } else {
            System.out.println("not connected to db");
        }

        List<Product> productList = new ArrayList<>();
        productList = ds.queryProducts();

        for(Product product : productList){
            System.out.println(product.toString());
        }

        List<Category> categoryList = new ArrayList<>();
        categoryList = ds.queryCategory();

        for(Category category : categoryList){
            System.out.println(category.toString());
        }

        ds.queryProductCategory();

    }

}
