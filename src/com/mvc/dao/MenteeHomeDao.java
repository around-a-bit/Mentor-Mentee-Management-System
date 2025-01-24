package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mvc.bean.MenteeDetails;
import com.mvc.bean.MenteeHomeBean;
import com.mvc.util.DBConnection;

public class MenteeHomeDao {
	public String menteeHomeDetails (MenteeHomeBean menteeHomeBean) 
	 {
		String mentee_email = menteeHomeBean.getMentee_email();
		System.out.println("mentee_email dao: "+mentee_email);
		String mentor_email = "";
		int i=0;
	     ResultSet resultSet=null;
	     ResultSet resultSet1=null;
	     ResultSet resultSet2=null;
	     Connection con = null;
	     PreparedStatement preparedStatement = null;
	     PreparedStatement preparedStatement1 = null;
	     PreparedStatement preparedStatement2 = null;
	     
	     
		 
	     try {
	    	 con = DBConnection.createConnection();

	         String query ="SELECT * FROM mentereg  WHERE email = ?";
	         System.out.println("DB connected");
	         preparedStatement = con.prepareStatement(query);
	         preparedStatement.setString(1,mentee_email);   
	         resultSet = preparedStatement.executeQuery();
	         
	         

	         boolean r=resultSet.next();
	         
	     	List<MenteeDetails> menteeDetailsList = new ArrayList<>();
	        MenteeDetails menteeDetails = new MenteeDetails();
	         
	         String query1 ="SELECT semester,mentor_email FROM mentee WHERE email= ?";
			 System.out.println("email: "+mentee_email);
	         preparedStatement1 = con.prepareStatement(query1);
	         preparedStatement1.setString(1,mentee_email);   
	         resultSet1 = preparedStatement1.executeQuery();

             boolean r1=resultSet1.next();
             
             menteeDetails.setSemester("No Data");
        	 menteeDetails.setMentor_email("No Data");
        	 menteeDetails.setMentor_name("No Data");
        	 menteeDetails.setMentor_mobile((1234567890L));
			 System.out.println("r: "+r);
			 System.out.println("r2: "+r1);
			 
			 System.out.println("Mentor Email: "+resultSet1.getString("mentor_email"));
	         while(r && r1) {
	        	 
	        	 menteeDetails.setName(resultSet.getString("name"));
	        	 menteeDetails.setUid(resultSet.getString("uid"));
	        	 menteeDetails.setSchool_name(resultSet.getString("school_name"));
	        	 menteeDetails.setDepartment_name(resultSet.getString("department_name"));
	        	 menteeDetails.setEmail(resultSet.getString("email"));
	        	 menteeDetails.setMobile(Long.parseLong(resultSet.getString("mobile")));
	        	 
	        	 menteeDetails.setSemester(resultSet1.getString("semester"));
	        	 menteeDetails.setMentor_email(resultSet1.getString("mentor_email"));
	        	 
	                i+=1;
	                break;
	            }
System.out.println("hiiiiii");
	         String query2 ="SELECT name, mobile FROM mentoreg WHERE email= ?";
	         preparedStatement2 = con.prepareStatement(query2);
	         preparedStatement2.setString(1,resultSet1.getString("mentor_email"));   
	         resultSet2 = preparedStatement2.executeQuery(); 
	         boolean r2 = resultSet2.next();
	         System.out.println("r2: "+r2);
	         while(r2) {
	        	 menteeDetails.setMentor_name(resultSet2.getString("name"));
	        	 
	        	 menteeDetails.setMentor_mobile(Long.parseLong(resultSet.getString("mobile")));
	        	 break;
	         }
	         
	            menteeDetailsList.add(menteeDetails);
	            menteeHomeBean.setMenteeDetails(menteeDetailsList);
			 
			 if (i!=0) {
				 System.out.println("SUCCESS");
				 return "SUCCESS";
			 }
			 else {
				 System.out.println("Error: Something went wrong! A");
				 return "Error: Something went wrong!";
			 }

	     }catch (SQLException e) {
	            e.printStackTrace();
				System.out.println("Error: Something went wrong! B");
	            return "Error: Something went wrong!"; 
	        }finally {
	            try {
	                if (resultSet != null) {
	                    resultSet.close();
	                }
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                System.out.println( e );
	            }
	        }
	 

	 }
}