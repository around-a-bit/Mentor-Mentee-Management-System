package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
 public static Connection createConnection()
 {
     Connection con = null;
     String url = "jdbc:mysql://localhost:3306/mentor_mentee_management_system"; //MySql URL followed by the database name
     String username = "root"; // mySql user name
     String password = "cyber123"; //mySql password
    
     //System.out.println("In DBConnection.java class ");
      
     try
     {
         try
         {
            Class.forName("com.mysql.cj.jdbc.Driver"); //loading H2 drivers. This differs for database servers 
         } 
         catch (ClassNotFoundException e)
         {
            e.printStackTrace();
         }       
         con = DriverManager.getConnection(url, username, password); //attempting to connect to H2 database
         System.out.println("Printing connection object "+con);
     } 
     catch (Exception e) 
     {
        e.printStackTrace();
     }   
     return con; 
 }
}