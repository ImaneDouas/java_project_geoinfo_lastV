package com.example.demo1.Model;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = " java_project_geoinfo";
        String databaseUser = "root";
        String databasePassword = "";
        //String url = "jdbc:mysql://localhost:8001/" + databaseName;
        String url = "jdbc:mysql://localhost/" + databaseName + "?serverTimezone=UTC";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("Connected to the database successfully!");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}