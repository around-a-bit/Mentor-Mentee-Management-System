package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.MentorInteractionBean;
import com.mvc.util.DBConnection;

public class MentorInteractionDao {
	public String MentorInteractionDetails (MentorInteractionBean mentorInteractionBean)
	 {
		String uid = mentorInteractionBean.getUid();
		String date = mentorInteractionBean.getDate();
		String interaction = mentorInteractionBean.getInteraction();
		String problem = mentorInteractionBean.getProblem();
		String remedy = mentorInteractionBean.getRemedy();
		String changes = mentorInteractionBean.getChanges();
		String attendance = mentorInteractionBean.getAttendance();
		String cgpa = mentorInteractionBean.getCgpa();
		String id = mentorInteractionBean.getId();
		String mentee_department = mentorInteractionBean.getMentee_department();
		String mentee_school = mentorInteractionBean.getMentee_school();
		String mentor_email = mentorInteractionBean.getMentor_email();
		
		System.out.println("Dao Page");
		Connection con = null;
		PreparedStatement preparedStatement = null;
		 try
		 {
			 con = DBConnection.createConnection();
			 String query = "INSERT into interactions(interaction_id, interaction_date ,name_school, name_department, uid_mentee,id_mentor, cgpa, attendance, interaction,problem,remedy,changes) values (NULL,?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setString(1, date);
			 preparedStatement.setString(2, mentee_school);
			 preparedStatement.setString(3, mentee_department);
			 preparedStatement.setString(4,uid );
			 preparedStatement.setString(5,id );
			 preparedStatement.setString(6,cgpa );
			 preparedStatement.setString(7,attendance );
			 preparedStatement.setString(8,interaction );
			 preparedStatement.setString(9,problem );
			 preparedStatement.setString(10,remedy );
			 preparedStatement.setString(11,changes );
			 
			 int i= preparedStatement.executeUpdate();
			 
			 if (i!=0)  //Just to ensure data has been inserted into the database
			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace();
		 }
		 return "Oops.. Something went wrong there..!";
	 }
}