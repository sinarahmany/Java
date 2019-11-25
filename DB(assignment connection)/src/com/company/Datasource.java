package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    private final String DATABASE_ASSIGNMENT = "business.db";
    private final String connectionString = "jdbc:sqlite:";
    private PreparedStatement queryProductsInfo;
    private PreparedStatement queryCategoryInfo;
    private PreparedStatement queryProductCategoryInfo;
    private Connection conn;
    public boolean open(){
        try {
            conn = DriverManager.getConnection(connectionString + DATABASE_ASSIGNMENT);
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Product> queryProducts(){

        List<Product> pl = new ArrayList<>();
        try {
            queryProductsInfo = conn.prepareStatement("SELECT * FROM products");
            ResultSet rs = queryProductsInfo.executeQuery();

            while(rs.next()){
                pl.add(new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getDouble("price"),
                                rs.getInt("currency_id")
                        )
                );
            }


        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

        return pl;

    }

    public List<Category> queryCategory(){

        List<Category> cl = new ArrayList<>();
        try {
            queryCategoryInfo = conn.prepareStatement("SELECT * FROM categories");
            ResultSet rs = queryCategoryInfo.executeQuery();

            while(rs.next()){
                cl.add(new Category(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("sub_category_id")
                        )
                );
            }


        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

        return cl;

    }

    public void queryProductCategory(){

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT p.name AS Product,  p.price AS Price, c.name AS Category ");
            sb.append("FROM products p ");
            sb.append("JOIN products_categories pc ");
            sb.append("ON p.id = pc.products_id ");
            sb.append("JOIN categories c ");
            sb.append("ON c.id = pc.categories_id ");
            sb.append("ORDER BY p.name");
            queryCategoryInfo = conn.prepareStatement(sb.toString());
            ResultSet rs = queryCategoryInfo.executeQuery();
            System.out.println("________________________________________");
            System.out.format("%-15s %-6s %-6s\n", "Product","Price", "Category");
            System.out.println("________________________________________");
            while(rs.next()){
                System.out.format("%-15s %-6s %-6s\n",
                        rs.getString("Product"),
                        rs.getDouble("Price"),
                        rs.getString("Category")
                );
            }
            System.out.println("________________________________________");


        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


    private int insertProduct(String name,String decription ,double price , int currency_id)throws SQLException{
        queryProductsInfo =  conn.prepareStatement("SELECT product FROM products WHERE name = ?");
        queryProductsInfo.setString(1,name);
        ResultSet results =queryProductsInfo.executeQuery();
        if (results.next()){
            return results.getInt(1);
        }else{
            PreparedStatement insertIntoProducts =conn.prepareStatement("INSERT INTO products VALUES = ?,?,?,? ",
                    Statement.RETURN_GENERATED_KEYS);
            insertIntoProducts.setString(1,name);
            insertIntoProducts.setString(2,decription);
            insertIntoProducts.setString(3,price);
            insertIntoProducts.setString(4,currency_id);
            int affectedRows = insertIntoProducts.executeUpdate();

            if (affectedRows !=  1){
                throw new SQLException("Couldn`t insert product!");
            }
            ResultSet generatedKeys = insertIntoProducts.getGeneratedKeys();
            if (generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else {
                throw new SQLException("Couldn`t get _id for product");
            }
        }
    }















}
