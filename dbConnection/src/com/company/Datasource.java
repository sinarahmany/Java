package com.company;

import org.sqlite.SQLiteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    private Connection conn;
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    private  String connectionString = "jdbc:sqlite:C:\\work\\Java\\IdeaProjects\\dbConnection\\src\\com\\company\\music.db";
    public boolean open(){
        try{
             // statement.execute("CREATE TABLE IF NOT EXISTS classroom3(name TEXT,capacity INTEGER)");
             //statement.execute("INSERT INTO artists VALUES (203,'hamed')");
             conn = DriverManager.getConnection(connectionString);
             return true;
            Statement statement = conn.createStatement();
            ResultSet results = statement.getResultSet();
                 System.out.println("name " + results.getString("name"));
        }catch(Exception e){
             System.out.println(e.getMessage());
             return false;
        }
    }
    public List<Artist> queryForArtists(){
        List<Artist> artists =new ArrayList<Artist>();
        try {
            Statement statement = conn.createStatement();
            statement.execute("SELECT * FROM artists");
            ResultSet rs = statement.getResultSet();
            while (rs.next()){
                artists.add(new Artist(rs.getInt("_id"),rs.getString("name")));
            }
        }catch (SQLiteException e){
            System.out.println(e.getMessage());
            return null;
        }

    }



}
