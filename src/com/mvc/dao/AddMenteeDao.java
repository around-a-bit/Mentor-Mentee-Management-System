package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.AddMenteeBean;
import com.mvc.util.DBConnection;


public class AddMenteeDao {
	public String menteeDetails (AddMenteeBean addMenteeBean)
	 {  
		System.out.println("\nAddMentee Dao page");
		String semester = addMenteeBean.getSemester();
		String mentee_uid = addMenteeBean.getMentee_uid();
		String mentee_school = addMenteeBean.getMentee_school();
		String mentee_department = addMenteeBean.getMentee_department();
		String mentor_email = addMenteeBean.getMentor_email();
		
		System.out.println("mentor_email: "+mentor_email);
		Connection con = null;
		 PreparedStatement preparedStatement = null;		 
		 try
		 {
			 con = DBConnection.createConnection();
			 String query = "INSERT INTO mentee (mentee_id, mentor_email, email, school_name, department_name, semester)\r\n" +
					 "(SELECT ?, ?, mr.email, s.school_name, d.department_name, ? \r\n" +
					 "FROM mentereg mr\r\n" +
					 "INNER JOIN school s ON mr.school_name = s.school_name \r\n" +
					 "INNER JOIN department d ON mr.department_name = d.department_name \r\n" +
					 "WHERE mr.uid = ? AND s.school_name = ? AND d.department_name = ?)";

 //Insert user details into the table 'USERS'
			 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setString(1, mentee_uid);
			 preparedStatement.setString(2, mentor_email);
			 preparedStatement.setString(3, semester);
			 preparedStatement.setString(4, mentee_uid);
			 preparedStatement.setString(5, mentee_school);
			 preparedStatement.setString(6, mentee_department);
			 
			 System.out.println("Query execution done \n\n");
			 
			 int i= preparedStatement.executeUpdate();
			 

			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace();
			
		 }
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
}