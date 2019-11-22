package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {



    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\work\\Java\\IdeaProjects\\assignmentDB\\src\\com\\company\\assigment.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectAll(){
        String sql = "SELECT id, name FROM products";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
