package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.AddMenteeBean;
import com.mvc.bean.IntDateDetails;
import com.mvc.bean.InteractionMenteeServletBean;
import com.mvc.bean.MentorDetails;
import com.mvc.util.DBConnection;

public class InteractionMenteeServletDao {
	public String dateDetails (InteractionMenteeServletBean interactionMenteeServletBean)
	 {  
		System.out.println("\nAddMentee Dao page");
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		String mentor_email = interactionMenteeServletBean.getMentor_email();
		String mentee_uid = interactionMenteeServletBean.getMentee_uid();
		String mentor_uid = "";
		
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 PreparedStatement preparedStatement1 = null;
		 try
		 {
			 con = DBConnection.createConnection();
			 
			 String query1 = "SELECT uid FROM mentoreg WHERE email = ? ";
			 preparedStatement1 = con.prepareStatement(query1);
			 preparedStatement1.setString(1, mentor_email);
			 resultSet1 = preparedStatement1.executeQuery();
	         boolean r1=resultSet1.next();
	         while(r1) {
	        	 mentor_uid = resultSet1.getString("uid");
	        	 break;
	         }
			 
			 String query = "SELECT interaction_date from interactions WHERE uid_mentee = ? AND  id_mentor = ?";

//Insert user details into the table 'USERS'
			 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setString(1, mentee_uid);
			 preparedStatement.setString(2, mentor_uid);
			 int i = 0;
			 System.out.println("Query execution done \n\n");
			 
	         resultSet = preparedStatement.executeQuery();
	         boolean r=resultSet.next();
	         List<IntDateDetails> intDateDetailsList= new ArrayList<>();
	         IntDateDetails intDateDetails = new IntDateDetails();
			 while(r) {
				 intDateDetails.setDate(resultSet.getString("interaction_date"));
				 i+=1;
				 break;
			 }
			 
			 intDateDetailsList.add(intDateDetails);
			 InteractionMenteeServletBean.setIntDateDetails(intDateDetailsList);

			 if(i!=0) {
				 return "SUCCESS"; 
			 }
			 
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace();
			
		 }
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
}
