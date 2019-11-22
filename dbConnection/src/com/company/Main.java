package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    Datasource ds =new Datasource();
    List<Artist> artistList = new ArrayList<Artist>();
    if (ds.open()){
        artistList = ds.queryForArtists();
        System.out.println("connected to DB");
    }else {
        System.out.println("not conncted to DB");
    }
    for (Artist i : artistList){
        System.out.println(i.getId() + " " + i.getName());
    }
    //ds.close();





        //or instead of class we can use the method below
//        try{
//        Connection conn = DriverManager.getConnection(
//                "jdbc:sqlite:C:\\work\\Java\\IdeaProjects\\dbConnection\\src\\com\\company\\music.db");
//            Statement statement = conn.createStatement();
//           // statement.execute("CREATE TABLE IF NOT EXISTS classroom3(name TEXT,capacity INTEGER)");
//            //statement.execute("INSERT INTO artists VALUES (203,'hamed')");
//            statement.execute("SELECT name from artists");
//            ResultSet results = statement.getResultSet();
//            while (results.next()){
//                System.out.println("name " + results.getString("name"));
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
    }

}
