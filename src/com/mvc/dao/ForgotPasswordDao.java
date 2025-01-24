package com.mvc.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.ForgotPasswordBean;
import com.mvc.util.DBConnection;

public class ForgotPasswordDao {
	public String emailDetails (ForgotPasswordBean forgotPasswordBean) throws NoSuchAlgorithmException
	 {
		
		String role = forgotPasswordBean.getRole();;
		String email = forgotPasswordBean.getEmail();
		String email1 = null;
		
		
		 Connection con = null;
		 ResultSet resultSet = null;
		 PreparedStatement preparedStatement = null;	
		 
		 if("mentor".equals(forgotPasswordBean.getRole())) {
			 try {
				    con = DBConnection.createConnection();
				    String query = "SELECT email FROM mentoreg WHERE email = ?";
				    preparedStatement = con.prepareStatement(query);
				    preparedStatement.setString(1, email);

				    resultSet = preparedStatement.executeQuery();

				    if (resultSet.next()) {
//				    	System.out.println("Checking");
				        email1 = resultSet.getString("email");

				        if (email.equals(email1)) {
				            return "SUCCESS";
				        } else {
				        	return "Email Not Found";  // More informative error message
				        }
				    } else {
				        System.out.println("No record found for email and role");
				        return "No record found for email and role";  // More informative error message
				    }
				} catch (SQLException e) {
				    e.printStackTrace();
				    return "No record found for email and role";  // Generic error message
				}
		 }
		 else if("mentee".equals(forgotPasswordBean.getRole())) {
			 try {
				    con = DBConnection.createConnection();
				    String query = "SELECT email FROM mentereg WHERE email = ?";
				    preparedStatement = con.prepareStatement(query);
				    preparedStatement.setString(1, email); // Informative message
				    resultSet = preparedStatement.executeQuery();

				    // Check if a record is found
				    if (resultSet.next()) {
				    	System.out.println("Checking");
				        email1 = resultSet.getString("email");
				        
				        if (email.equals(email1)) {
				            System.out.println("Email Matched!");
				            return "SUCCESS";
				        } else {
				            System.out.println("Email Not Found");
				            return "Email Not Found";  // More informative error message
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
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
}
