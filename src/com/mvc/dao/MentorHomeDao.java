package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.MentorDetails;
import com.mvc.bean.MentorHomeBean;
import com.mvc.util.DBConnection;

public class MentorHomeDao {
	public String mentorHomeDetails (MentorHomeBean mentorHomeBean, String mentor_email)
	 {
		String check = mentorHomeBean.getCheck();
		String remarks = mentorHomeBean.getRemarks();
		String joining_date = mentorHomeBean.getJoining_date();
		
		
		
		System.out.println("Page: MentorHome Dao");
		int i=0;
		
		System.out.println("mentor_email dao: "+mentor_email);
		ResultSet resultSet = null;
		
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 PreparedStatement preparedStatement1 = null;

		 try
		 {
			 con = DBConnection.createConnection(); 
			 if(check != null) {
				 String query1 = "UPDATE mentoreg SET remarks = ?, joining_date = ? WHERE email = ?"; //Insert user details into the table 'USERS'
				 preparedStatement1 = con.prepareStatement(query1);
				 preparedStatement1.setString(1,remarks ); 
				 preparedStatement1.setString(2,joining_date ); 
				 preparedStatement1.setString(3,mentor_email );
				 preparedStatement1.executeUpdate();
				 System.out.println("Email:"+mentor_email);
				 System.out.println("update");
			 }

			 String query = "SELECT * FROM mentoreg WHERE email = ?"; //Insert user details into the table 'USERS'
			 preparedStatement = con.prepareStatement(query);
			 preparedStatement.setString(1,mentor_email );
			 
	         resultSet = preparedStatement.executeQuery();
	         boolean r=resultSet.next();
	         
	     	List<MentorDetails> mentorDetailsList = new ArrayList<>();
	        MentorDetails mentorDetails = new MentorDetails();
	         
	         
	            while (r) {
	                mentorDetails.setSchool_name(resultSet.getString("school_name"));
	                mentorDetails.setDepartment(resultSet.getString("department_name"));
	                mentorDetails.setMentor_name(resultSet.getString("name"));
	                mentorDetails.setMentor_email(resultSet.getString("email"));
	                mentorDetails.setMentor_mobile(Long.parseLong(resultSet.getString("mobile")));
	                mentorDetails.setUid(resultSet.getString("uid"));
	                mentorDetails.setJoining_date(resultSet.getString("joining_date"));
	                mentorDetails.setRemarks(resultSet.getString("remarks"));
	                i+=1;
	                break;
	            }
	         
			 
	            mentorDetailsList.add(mentorDetails);
	            mentorHomeBean.setMentorDetails(mentorDetailsList);
			 
			 if (i!=0) {
				 return "SUCCESS";
			 }
			 else {
				 return "Error: Something went wrong!";
			 }
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace();
		 }
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
	

}