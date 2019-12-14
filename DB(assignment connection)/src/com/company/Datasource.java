package com.company;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

public class Datasource {
    private final String DATABASE_BUSINESS  = "business.db";
    private final String CONNECTION_STRING  = "jdbc:sqlite:";
    private Connection conn;
    private PreparedStatement queryProductsInfo;
    private PreparedStatement queryCategoryInfo;
    private PreparedStatement queryCustomersInfo;
    private PreparedStatement queryProductCategoryCurrenciesInfo;
    private PreparedStatement queryProductCategoryInfo;
    private PreparedStatement queryProduct;
    private PreparedStatement queryCategory;
    private PreparedStatement queryCustomer;
    private PreparedStatement queryCard;
    private PreparedStatement insertIntoProducts;
    private PreparedStatement insertIntoCatagories;
    private PreparedStatement insertIntoCustomers;
    private PreparedStatement queryProductCategory;
    private PreparedStatement insertIntoProductCategories;
    private PreparedStatement deleteProducts;
    private PreparedStatement deleteProductsCategory;
    private PreparedStatement deleteCustomer;
    private PreparedStatement updateProducts;
    private PreparedStatement updateCustomers;
    private PreparedStatement deleteCards;
    private PreparedStatement insertIntocards;
    private PreparedStatement insertIntoCard_details;


    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING + DATABASE_BUSINESS);



            StringBuilder productcategoryquery = new StringBuilder();
            productcategoryquery.append("SELECT p.name AS Product,  p.price AS Price, c.name AS Category ");
            productcategoryquery.append("FROM products p ");
            productcategoryquery.append("JOIN products_categories pc ");
            productcategoryquery.append("ON p.id = pc.products_id ");
            productcategoryquery.append("JOIN categories c ");
            productcategoryquery.append("ON c.id = pc.categories_id ");
            productcategoryquery.append("JOIN currencies cur ");
            productcategoryquery.append("ON p.currency_id = cur.id ");
            productcategoryquery.append("where p.active = 1 ");
            productcategoryquery.append("ORDER BY p.name");
            queryProductCategoryInfo = conn.prepareStatement(productcategoryquery.toString());


            StringBuilder sb = new StringBuilder();
            sb.append("SELECT p.name AS Product,  p.price AS Price, c.name AS Category, ");
            sb.append("(SELECT curp.value FROM currencies_price curp WHERE id = 2) * p.price AS PriceUSD, ");
            sb.append("(SELECT curp.value FROM currencies_price curp WHERE id = 4) * p.price AS PriceJPY ");
            sb.append("FROM products p ");
            sb.append("JOIN products_categories pc ");
            sb.append("ON p.id = pc.products_id ");
            sb.append("JOIN categories c ");
            sb.append("ON c.id = pc.categories_id ");
            sb.append("JOIN currencies cur ");
            sb.append("ON p.currency_id = cur.id ");
            sb.append("JOIN currencies_price curp ");
            sb.append("ON curp.currency_id  = cur.id ");
            sb.append("where p.active = 1 ");
            sb.append("ORDER BY p.name");
            queryProductCategoryCurrenciesInfo = conn.prepareStatement(sb.toString());

            queryProduct = conn.prepareStatement("SELECT * FROM products WHERE name = ? AND active = 1");
            queryProductsInfo = conn.prepareStatement("SELECT * FROM products WHERE active = 1");
            queryCard = conn.prepareStatement("SELECT * FROM cards WHERE customer_id = ? AND active = 1");
            queryCategory = conn.prepareStatement("SELECT * FROM categories WHERE name = ? AND active = 1");
            queryCategoryInfo = conn.prepareStatement("SELECT * FROM categories WHERE active =1");
            queryCustomersInfo = conn.prepareStatement("SELECT * FROM customers WHERE active =1");
            insertIntoProducts = conn.prepareStatement("INSERT INTO products (name, description, price, currency_id, created_at) VALUES(?, ? , ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertIntoCatagories = conn.prepareStatement("INSERT INTO categories (name, sub_category_id, created_at) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            queryProductCategory = conn.prepareStatement("SELECT * FROM products_categories WHERE products_id = ? AND categories_id = ? AND active =1");
            queryCustomer = conn.prepareStatement("SELECT * FROM customers WHERE email = ? AND active = 1", Statement.RETURN_GENERATED_KEYS);
            insertIntoProductCategories = conn.prepareStatement("INSERT INTO products_categories (products_id, categories_id, created_at) VALUES (?, ?, ?)");
            insertIntoCustomers = conn.prepareStatement("INSERT INTO customers (name, email, address, phone, created_at) VALUES (? , ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            deleteProducts = conn.prepareStatement("UPDATE products SET active = 0 WHERE id  = ?  ");
            deleteProductsCategory = conn.prepareStatement("UPDATE products_categories SET active = 0 WHERE products_id  = ? ");
            deleteCustomer = conn.prepareStatement("UPDATE customers SET active = 0 WHERE id = ?");
            updateProducts = conn.prepareStatement("UPDATE products SET price = ? WHERE id = ? ");
            updateCustomers = conn.prepareStatement("UPDATE customers SET name = ? WHERE id = ? ");
            deleteCards = conn.prepareStatement("UPDATE cards SET active = 0 WHERE customer_id = ? ");
            insertIntocards = conn.prepareStatement("INSERT INTO cards (customer_id, created_at) VALUES (?, ?)");
            insertIntoCard_details = conn.prepareStatement("INSERT INTO card_details (card_id, product_id, quantity, currency_id,total_amount, created_at) VALUES (? , ?, ?, ?, ?, ?)");
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {


            if (queryProductsInfo != null) {
                queryProductsInfo.close();
            }

            if (queryCategoryInfo != null) {
                queryCategoryInfo.close();
            }


            if (queryProductCategoryCurrenciesInfo != null) {
                queryProductCategoryCurrenciesInfo.close();
            }

            if (queryProductCategoryInfo != null) {
                queryProductCategoryInfo.close();
            }

            if (queryCategory != null) {
                queryCategory.close();
            }
            if (queryProduct != null) {
                queryProduct.close();
            }

            if(queryCard != null){
                queryCard.close();
            }

            if (insertIntoCatagories != null) {
                insertIntoCatagories.close();
            }
            if (insertIntoProducts != null) {
                insertIntoProducts.close();
            }
            if (insertIntoProductCategories != null) {
                insertIntoProductCategories.close();
            }
            if (insertIntoCustomers != null) {
                insertIntoCustomers.close();
            }
            if (updateCustomers != null) {
                updateCustomers.close();
            }
            if (updateProducts != null) {
                updateProducts.close();
            }
            if (deleteCustomer != null) {
                deleteCustomer.close();
            }
            if (deleteProductsCategory != null) {
                deleteProductsCategory.close();
            }
            if (deleteProducts != null) {
                deleteProducts.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public void queryProducts() {


        try {

            ResultSet rs = queryProductsInfo.executeQuery();


            System.out.println("__________________________________________________________________________________________________________");
            System.out.format("%-8s %-18s %-55s %-8s %-8s\n", "id", "name", "description", "price", "currency_id");
            System.out.println("__________________________________________________________________________________________________________");
            while (rs.next()) {
                System.out.format("%-8s %-18s %-55s %-12.2f %-8s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("currency_id")
                );
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }


    public void queryCategory() {

        try {
            ResultSet rs = queryCategoryInfo.executeQuery();


            System.out.println("______________________________________________");
            System.out.format("%-8s %-15s %-8s\n", "id", "name", "sub_category_id");
            System.out.println("______________________________________________");
            while (rs.next()) {
                System.out.format("%-8s %-22s %-8s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("sub_category_id")
                );
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }


    public void queryCustomers() {



        try {
            ResultSet rs = queryCustomersInfo.executeQuery();
            System.out.println("\u001B[34m______________________________________________________________________________________");
            System.out.format("%-7s %-30s %-20s %-12s %-10s\n", "id", "name", "email", "address", "phone");
            System.out.println("______________________________________________________________________________________\u001B[37m");
            while (rs.next()) {
                 {System.out.format("%-7s %-20.17s %-30.27s %-12.9s %-10s\n",

                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("address"),
                                    rs.getString("phone")

                    );
                }

            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }



    }

    public void queryProductCategory() {

        try {

            ResultSet rs = queryProductCategoryInfo.executeQuery();
            System.out.println("________________________________________");
            System.out.format("%-15s %-6s %-10s\n", "Product", "Price", "Category");
            System.out.format("%-15s %-6s %-10s\n", "", "CAD", "");

            System.out.println("________________________________________");
            while (rs.next()) {
                System.out.format("%-15s %-6.2f %-10s\n",
                        rs.getString("Product"),
                        rs.getDouble("Price"),
                        rs.getString("Category")
                );
            }
            System.out.println("________________________________________");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void queryProductCategoryCurrencies() {

        try {


            ResultSet rs = queryProductCategoryCurrenciesInfo.executeQuery();
            System.out.println("\u001B[34m_____________________________________________________");
            System.out.format("%-15s %-8s %-8s %-8s %-10s\n", "Product", "Price", "Price", "Price", "Category");
            System.out.format("%-15s %-8s %-8s %-8s %-10s\n", "", "CAD", "USD", "JPY", "");
            System.out.println("_____________________________________________________\u001B[37m");
            while (rs.next()) {
                System.out.format("%-15s %-8.2f %-8.2f %-8.2f %-10s\n",
                        rs.getString("Product"),
                        rs.getDouble("Price"),
                        rs.getDouble("PriceUSD"),
                        rs.getDouble("PriceJPY"),
                        rs.getString("Category")
                );
            }
            System.out.println("_____________________________________________________");


        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private int insertProduct(String name, String description, double price, int currency_id) throws SQLException {

        queryProduct.setString(1, name);
        ResultSet results = queryProduct.executeQuery();

        if (results.next()) {

            return results.getInt("id");

        } else {

            insertIntoProducts.setString(1, name);
            insertIntoProducts.setString(2, description);
            insertIntoProducts.setDouble(3, price);
            insertIntoProducts.setInt(4, currency_id);
            insertIntoProducts.setString(5, new Timestamp(currentTimeMillis()).toString());

            //this returns integer
            //execute will return boolean
            int affectedRows = insertIntoProducts.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert product!");
            }

            ResultSet generatedKeys = insertIntoProducts.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id for product");
            }
        }
    }

    public void insertCard(String name, String email, String address, String phone) throws SQLException {

        try {
            conn.setAutoCommit(false);

            int customer_id = insertCustomer(name, email, address, phone);


            //Check if exist on product category already
            queryCard.setInt(1, customer_id);

            ResultSet card = queryCard.executeQuery();
            if (card.next()) {
                throw new SQLException("This card already exist and linked in the database");
            }

            insertIntocards.setInt(1, customer_id);
            insertIntocards.setString(2, new Timestamp(currentTimeMillis()).toString());


            int affectedRows = insertIntocards.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
                conn.commit();
            } else {
                throw new SQLException("The card insert failed");
            }

        } catch (SQLException e) {
            System.out.println("Insert card exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("rollback failed " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }

        }

    }


    private int insertCategory(String name, int subCategory) throws SQLException {

        queryCategory.setString(1, name);
        ResultSet results = queryCategory.executeQuery();

        if (results.next()) {

            return results.getInt("id");

        } else {

            insertIntoCatagories.setString(1, name);
            insertIntoCatagories.setInt(2, subCategory);
            insertIntoCatagories.setString(3, new Timestamp(currentTimeMillis()).toString());

            //this returns integer
            //execute will return boolean
            int affectedRows = insertIntoCatagories.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert category!");
            }

            ResultSet generatedKeys = insertIntoCatagories.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id for category");
            }
        }
    }

    public void insertProductCategory(String productName, String productDescription, double productPrice, int currency_id, String categoryName, int subCategory) throws SQLException {

        try {
            conn.setAutoCommit(false);

            int productId = insertProduct(productName, productDescription, productPrice, currency_id);
            int categoryId = insertCategory(categoryName, subCategory);

            //Check if exist on product category already
            queryProductCategory.setInt(1, productId);
            queryProductCategory.setInt(2, categoryId);
            //new Timestamp(currentTimeMillis())

            ResultSet pc = queryProductCategory.executeQuery();
            if(pc.next()){
                throw new SQLException("This product and category already exist and linked in the database");
            }

            insertIntoProductCategories.setInt(1, productId);
            insertIntoProductCategories.setInt(2, categoryId);
            insertIntoProductCategories.setString(3, new Timestamp(currentTimeMillis()).toString());


            int affectedRows = insertIntoProductCategories.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
                conn.commit();
            } else {
                throw new SQLException("The product category insert failed");
            }

        } catch (SQLException e) {
            System.out.println("Insert product category exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("rollback failed " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }

        }

    }

    //inserting customer should insert card automaticaly

    //change this method to a transaction

    public int insertCustomer(String name, String email, String address, String phone ) throws SQLException {

        queryCustomer.setString(1, email);
        ResultSet results = queryCustomer.executeQuery();


        if (results.next()) {
            return results.getInt("id");



        } else {

            insertIntoCustomers.setString(1, name);
            insertIntoCustomers.setString(2, email);
            insertIntoCustomers.setString(3, address);
            insertIntoCustomers.setString(4, phone);
            insertIntoCustomers.setString(5, new Timestamp(currentTimeMillis()).toString());


            //this returns integer
            //execute will return boolean
            int affectedRows = insertIntoCustomers.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
            }

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert customer!");
            }

            ResultSet generatedKeys = insertIntoCustomers.getGeneratedKeys();
            if (generatedKeys.next()) {

                int gen = generatedKeys.getInt(1);
                insertIntocards.setInt(1,gen);
                insertIntocards.setString(2,new Timestamp(currentTimeMillis()).toString());
                return gen;
            } else {
                throw new SQLException("Couldn't get id for customer");
            }

        }

    }

    public void deletingProducts (String email) throws SQLException{
        queryProduct.setString(1, email);
        ResultSet results = queryProduct.executeQuery();

        if (results.next()) {

            int products_id = results.getInt("id");
            deleteProducts.setInt(1,products_id);
            deleteProductsCategory.setInt(1,products_id);
            int affectedRows1 = deleteProducts.executeUpdate();
            int affectedRows2 = deleteProductsCategory.executeUpdate();

            if (affectedRows1 != 1 || affectedRows2 != 1) {
                throw new SQLException("Couldn't Delete Product!");
            }else{
                System.out.println("SUCCESSFUL");
            }


        } else {

            System.out.println("Couldn't get id for Product");
        }
    }


    public void deletingCustomer (String name) throws SQLException{
        try {
            conn.setAutoCommit(false);

            queryProduct.setString(1, name);
            ResultSet results = queryProduct.executeQuery();

            if (results.next()) {

                int products_id = results.getInt("id");
                //update products set active = 0 where id = products_id
                deleteProductsCategory.setInt(1, products_id);
                deleteProducts.setInt(1, products_id);

                int affectedRows = deleteProductsCategory.executeUpdate();
                int affectedRows2 = deleteProducts.executeUpdate();

                if (affectedRows == 1 && affectedRows2 == 1) {
                    System.out.println("Commitment completed successfully");
                    conn.commit();
                } else {
                    throw new SQLException("The product category delete failed");
                }
            }

        } catch (SQLException e) {
            System.out.println("delete product category exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("rollback failed " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }
    }

    public void updateProducts(String productName, double productPrice) throws SQLException {

        queryProduct.setString(1, productName);
        ResultSet results = queryProduct.executeQuery();

        if (results.next()) {

            int products_id = results.getInt("id");

            updateProducts.setDouble(1, productPrice);
            updateProducts.setInt(2, products_id);


            int affectedRows = updateProducts.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't update product!");
            }else{
                System.out.println("SUCCESSFUL");
            }

        } else {
            System.out.println("product does not exist");
        }
    }


    public void updateCustomers(String customerEmail , String customerNewName) throws SQLException {

        queryCustomer.setString(1, customerEmail);
        ResultSet results = queryCustomer.executeQuery();

        if (results.next()) {

            int customer_id = results.getInt("id");

            updateCustomers.setString(1, customerNewName);
            updateCustomers.setInt(2, customer_id);


            int affectedRows = updateCustomers.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't update product!");
            }else{
                System.out.println("SUCCESSFUL");
            }


        } else {
            System.out.println("customer does not exist");
        }

    }
    public void insertCardDetails(String customerEmail, String productName, int quantity) throws SQLException {

        queryCustomer.setString(1, customerEmail);
        ResultSet results = queryCustomer.executeQuery();

        if (results.next()) {

            int customer_id = results.getInt("id");


            queryCard.setInt(1, customer_id);
            ResultSet rs = queryCard.executeQuery();

            int card_id = rs.getInt("id");

            queryProduct.setString(1, productName);
            ResultSet result = queryProduct.executeQuery();

            int product_id = result.getInt("id");
            double price = result.getDouble("price");
            int currency_id = result.getInt("currency_id");


            insertIntoCard_details.setInt(1, card_id);
            insertIntoCard_details.setInt(2, product_id);
            insertIntoCard_details.setInt(3, quantity);
            insertIntoCard_details.setInt(4, currency_id);
            insertIntoCard_details.setDouble(5, (quantity * price));
            insertIntoCard_details.setString(6, new Timestamp(currentTimeMillis()).toString());

            int affectedRows = insertIntoCard_details.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("Commitment completed successfully");
            }

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert card details!");
            }
        }else {
            throw new SQLException("Customer does not exist");
        }
    }


    public boolean checkProducts(String productName) throws SQLException {

        queryProduct.setString(1, productName);
        ResultSet results = queryProduct.executeQuery();

        if (!results.next()) {
            System.out.println("product does not exist");
            return false;
        } else {
            return true;
        }
    }
    public boolean checkCustomers(String customerEmail) throws SQLException {

        queryCustomer.setString(1, customerEmail);
        ResultSet results = queryCustomer.executeQuery();

        if (!results.next()) {
            System.out.println("customer does not exist");
            return false;
        } else {
            return true;
        }

    }





}
