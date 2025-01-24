package com.mvc.dao;


import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;
import com.mvc.security.Hash;

public class LoginDao {
	public String loginDetails (LoginBean loginBean) throws NoSuchAlgorithmException
	 {
		Hash hash = new Hash();
		
		String pass = null;
		String email_ = loginBean.getEmail();

		String s = loginBean.getPassword();
		String password = hash.hashString(s);
		
		System.out.println("Page: LoginDao");
		
//		System.out.println("password: "+password);
		
		 Connection con = null;
		 ResultSet resultSet = null;
		 PreparedStatement preparedStatement = null;	
		 
		 if("mentor".equals(loginBean.getRole())) {
			 try {
				    con = DBConnection.createConnection();
				    String query = "SELECT password_hash FROM mentoreg WHERE email = ?";
				    preparedStatement = con.prepareStatement(query);
				    preparedStatement.setString(1, email_);
				    
				     // Informative message
				    resultSet = preparedStatement.executeQuery();
//				    System.out.println(resultSet);
//				    System.out.println("Mentor Portion");
//				    System.out.println("Fetching password"); 
				    // Check if a record is found
				    if (resultSet.next()) {
//				    	System.out.println("Checking");
				        pass = resultSet.getString("password_hash");
//				        System.out.println("Password retrieved");
//				        System.out.println("pass: "+pass);
//				        System.out.println("password: "+password);

				        if (pass.equals(password)) {
//				            System.out.println("Password Matched!");
				            return "SUCCESS";
				        } else {
//				            System.out.println("Password mismatch");
				            return "Invalid Password";  // More informative error message
				        }
				    } else {
				        System.out.println("No record found for email and role");
				        return "Invalid Credentials";  // More informative error message
				    }
				} catch (SQLException e) {
				    e.printStackTrace();
				    return "Error: Something went wrong!";  // Generic error message
				}
		 }
		 else if("mentee".equals(loginBean.getRole())) {
			 try {
				    con = DBConnection.createConnection();
				    String query = "SELECT password_hash FROM mentereg WHERE email = ?";
				    preparedStatement = con.prepareStatement(query);
				    preparedStatement.setString(1, email_);
				    System.out.println("Mentee Portion");
				    System.out.println("Fetching password");  // Informative message
				    resultSet = preparedStatement.executeQuery();

				    // Check if a record is found
				    if (resultSet.next()) {
				    	System.out.println("Checking");
				        pass = resultSet.getString("password_hash");
				        System.out.println("Password retrieved");  // Informative message
				        System.out.println("pass: "+pass);
				        System.out.println("password: "+password);
				        
				        if (pass.equals(password)) {
				            System.out.println("Password Matched!");
				            return "SUCCESS";
				        } else {
				            System.out.println("Password mismatched");
				            return "Invalid Password";  // More informative error message
				        }
				    } else {
				        System.out.println("No record found for email and role");
				        System.out.println("A");
				        return "No record found for email and role";  // More informative error message
				    }
				} catch (SQLException e) {
				    e.printStackTrace();
				    System.out.println("B");
				    return "Error: Something went wrong!";  // Generic error message
				}
		 }
		 
		 else if("admin".equals(loginBean.getRole())) {
			 try {
				    con = DBConnection.createConnection();
				    String query = "SELECT password_hash FROM adminreg WHERE email = ?";
				    preparedStatement = con.prepareStatement(query);
				    preparedStatement.setString(1, email_);
				    System.out.println("Admin Portion");
				    System.out.println("Fetching password");  // Informative message
				    resultSet = preparedStatement.executeQuery();

				    // Check if a record is found
				    if (resultSet.next()) {
				    	System.out.println("Checking");
				        pass = resultSet.getString("password_hash");
				        System.out.println("Password retrieved");  // Informative message
				        System.out.println("pass: "+pass);
				        System.out.println("password: "+password);
				        
				        if (pass.equals(password)) {
				            System.out.println("Password Matched!");
				            return "SUCCESS";
				        } else {
				            System.out.println("Password mismatched");
				            return "Invalid Password";  // More informative error message
				        }
				    } else {
				        System.out.println("No record found for email and role");
				        System.out.println("A");
				        return "No record found for email and role";  // More informative error message
				    }
				} catch (SQLException e) {
				    e.printStackTrace();
				    System.out.println("B");
				    return "Error: Something went wrong!";  // Generic error message
				}
		 }
		 
		 
		 
		 
		 System.out.println("C");
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
}