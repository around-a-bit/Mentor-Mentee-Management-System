package com.mvc.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
import com.mvc.security.Hash;

public class RegisterDao {
	public String registerDetails (RegisterBean registerBean) throws NoSuchAlgorithmException
	 {
		Hash hash = new Hash();

		String school = "";
		String department = "";
		school = registerBean.getSchool();
		department = registerBean.getDepartment();
		String name = registerBean.getName();
		String uid = registerBean.getUid();
		String email = registerBean.getEmail();
		String remarks = registerBean.getRemarks();
		String date_of_joining = registerBean.getDate_of_joining();
		String role = registerBean.getRole();
		System.out.println("Dao role: "+role);
		long mobile = registerBean.getMobile();
		
		String s = registerBean.getPassword();		
		String password = hash.hashString(s);
		
		System.out.println("Dao Page");
		

		
		
		Connection con = null;
		 
		 if("mentor".equals(registerBean.getRole())) {
			 PreparedStatement preparedStatement = null;		 
			 try
			 {
				 System.out.println("In mentor");
				 con = DBConnection.createConnection();
				 String query = "INSERT into mentoreg(mentor_id ,school_name,department_name,name,email,password_hash,mobile,uid,joining_date,remarks) values (NULL,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
				 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				 preparedStatement.setString(1, school);
				 preparedStatement.setString(2, department);
				 preparedStatement.setString(3, name);
				 preparedStatement.setString(4,email );
				 System.out.println("Password Entered: "+password);
				 preparedStatement.setString(5,password );
				 preparedStatement.setLong(6,mobile );
				 preparedStatement.setString(7,uid );
				 preparedStatement.setString(8, date_of_joining);
				 preparedStatement.setString(9, remarks);
				 
				 int i= preparedStatement.executeUpdate();
				 
				 if (i!=0)  //Just to ensure data has been inserted into the database
				 return "SUCCESS"; 
			 }
			 catch(SQLException e)
			 {
				e.printStackTrace();
			 }
		 }
		 else if ("mentee".equals(registerBean.getRole())) {
			 PreparedStatement preparedStatement = null;		 
			 try
			 {
				 System.out.println("In mentee");
				 con = DBConnection.createConnection();
				 String query = "INSERT into mentereg(school_name,department_name,name,email,password_hash,mobile,uid) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
				 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				 preparedStatement.setString(1, school);
				 preparedStatement.setString(2, department);
				 preparedStatement.setString(3, name);
				 preparedStatement.setString(4,email );
				 preparedStatement.setString(5,password );
				 System.out.println("Password Entered: "+password);
				 preparedStatement.setLong(6,mobile );
				 preparedStatement.setString(7,uid );
				 
				 int i= preparedStatement.executeUpdate();
				 
				 if (i!=0) {  //Just to ensure data has been inserted into the database
				 return "SUCCESS";
				 }
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Register dau SQL Exception");
				e.printStackTrace();
			 }
			 
		 }
		 
		 else if ("admin".equals(registerBean.getRole())) {
			 PreparedStatement preparedStatement = null;		 
			 try
			 {
				 System.out.println("In Admin");
				 con = DBConnection.createConnection();
				 String query = "INSERT into adminreg(name,email,password_hash,mobile,uid) values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
				 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				 preparedStatement.setString(1, name);
				 preparedStatement.setString(2,email );
				 preparedStatement.setString(3,password );
				 System.out.println("Password Entered: "+password);
				 preparedStatement.setLong(4,mobile );
				 preparedStatement.setString(5,uid );
				 
				 int i= preparedStatement.executeUpdate();
				 
				 if (i!=0) {  //Just to ensure data has been inserted into the database
				 return "SUCCESS";
				 }
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Register dau SQL Exception");
				e.printStackTrace();
			 }
			 
		 }
		 
		 System.out.println("Not");
		 return "UID Already Exist";  // On failure, send a message from here.
	 }
}