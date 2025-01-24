package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import com.mvc.bean.MenteeReportBean;
import com.mvc.util.DBConnection;
import com.mvc.bean.MenteeIntDetails; // Assuming this class exists

public class MenteeReportDao {

    public String menteeReportDetails(MenteeReportBean mentorReportBean,HttpSession session) {
        String int_date_mentee = mentorReportBean.getInt_date_mentee();
        String email= (String) session.getAttribute("email");
        System.out.println("MenteeReport Page.");
        String uid_mentee=null;
        Connection con = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        try {
            con = DBConnection.createConnection();
            
            String query ="SELECT uid FROM mentereg WHERE email= ?";
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1,email);
            
            resultSet = preparedStatement.executeQuery();
            System.out.println("resultSet: "+resultSet);
            
            if(resultSet.next()) {
            	uid_mentee =resultSet.getString("uid");
            }
            System.out.println("uid_mentee: "+uid_mentee);
            
            
            
            
            String query1 = "SELECT * FROM interactions WHERE uid_mentee = ? AND interaction_date = ?";
            preparedStatement1 = con.prepareStatement(query1);
            preparedStatement1.setString(1,uid_mentee);
            preparedStatement1.setString(2,int_date_mentee);
            resultSet1 = preparedStatement1.executeQuery();
            boolean r=resultSet1.next();
        	List<MenteeIntDetails> menteeIntDetailsList = new ArrayList<>();
            MenteeIntDetails menteeIntDetails = new MenteeIntDetails();
            
            while (r) {
                menteeIntDetails.setInteraction(resultSet1.getString("interaction"));
                System.out.println("interaction "+resultSet1.getString("interaction"));
                menteeIntDetails.setProblem(resultSet1.getString("problem"));
                System.out.println("problem "+resultSet1.getString("problem"));
                menteeIntDetails.setRemedy(resultSet1.getString("remedy"));
                System.out.println("remedy "+resultSet1.getString("remedy"));
                menteeIntDetails.setChanges(resultSet1.getString("changes"));
                System.out.println("changes "+resultSet1.getString("changes"));
                
                menteeIntDetailsList.add(menteeIntDetails);
                mentorReportBean.setMenteeIntDetails(menteeIntDetailsList);
 
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