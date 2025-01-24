package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mvc.bean.MentorReportBean;
import com.mvc.util.DBConnection;
import com.mvc.bean.Mentor_int_Details; // Assuming this class exists

public class MentorReportDao {

    public String mentorReportDetails(MentorReportBean mentorReportBean, HttpSession session) {
        String mentee_uid = mentorReportBean.getMentee_uid();
        String mentor_id = "";
        String date = mentorReportBean.getDate();
        String mentor_email = mentorReportBean.getMentor_email();
//        String email= (String) session.getAttribute("email");
        
        int i=0,j=0;
        
        Connection con = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        
    	List<Mentor_int_Details> mentor_int_DetailsList = new ArrayList<>();
    	
    	
        Mentor_int_Details mentor_int_Details = new Mentor_int_Details();

        try {
        	con = DBConnection.createConnection();
            
            String query2 = "SELECT uid FROM mentoreg WHERE email = ?";
            preparedStatement2 = con.prepareStatement(query2);
            preparedStatement2.setString(1, mentor_email);

            resultSet2 = preparedStatement2.executeQuery();
            boolean r2=resultSet2.next();
            
                while(r2) {
                	mentor_id = resultSet2.getString("uid");
                	break;
                }	
            
            

            
            String query = "SELECT * FROM interactions WHERE uid_mentee = ? AND id_mentor = ? AND interaction_date = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, mentee_uid);
            preparedStatement.setString(2, mentor_id);
            preparedStatement.setString(3, date);

            resultSet = preparedStatement.executeQuery();
            boolean r=resultSet.next();
            
            String query1="SELECT mr.name, m.semester FROM mentereg mr INNER JOIN mentee m ON mr.email = m.email WHERE mr.uid = ?";
            preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setString(1, mentee_uid);
            resultSet1 = preparedStatement1.executeQuery();
            boolean r1=resultSet1.next();
            


            
            while (r) {
                mentor_int_Details.setUid_mentee(resultSet.getString("uid_mentee"));
                mentor_int_Details.setName_department(resultSet.getString("name_department"));
                mentor_int_Details.setCgpa(resultSet.getString("cgpa"));
                mentor_int_Details.setAttendance(resultSet.getString("attendance"));
                mentor_int_Details.setInteraction(resultSet.getString("interaction"));
                mentor_int_Details.setProblem(resultSet.getString("problem"));
                mentor_int_Details.setRemedy(resultSet.getString("remedy"));
                mentor_int_Details.setChanges(resultSet.getString("changes"));
                i+=1;
                break;
            }

            while(r1) {
            	
                mentor_int_Details.setName(resultSet1.getString("name"));
                mentor_int_Details.setSemester(resultSet1.getString("semester"));
                j+=1;
                break;
            }
            
            mentor_int_DetailsList.add(mentor_int_Details);
            mentorReportBean.setMentor_int_Details(mentor_int_DetailsList);
            
            if(i!=0 && j!=0) {
            	return "SUCCESS";
            }
            
            	return "Error: Something went wrong!"; 

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: Something went wrong!"; 
        } finally {
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
                e.printStackTrace();
            }
        }
    }
}